package com.app.foodfinder.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.foodfinder.dto.*
import com.google.gson.Gson
import io.reactivex.Flowable.fromIterable
import io.reactivex.Observable
import io.reactivex.Observable.fromIterable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.rxkotlin.zipWith
import io.reactivex.schedulers.Schedulers

import java.util.*
import java.util.concurrent.TimeUnit
import java.util.logging.Logger

private const val TAG = "DataRepository"


public class DataRepository {


    private val disposable: CompositeDisposable = CompositeDisposable()

    private val searchData: MutableLiveData<MutableList<RestItemDetails>> = MutableLiveData()

    /*
    * This function converts restaurant and menu into observables and zips them together to return the search result
    * */
    public fun getSearchData(query: String): MutableLiveData<MutableList<RestItemDetails>> {

        var restaurant: List<Restaurant> = DataStore.getRestaurants()
        var menu: List<MenuX> = DataStore.getMenu()

        disposable.add(Observable.fromIterable(restaurant)
            .filter {
                it.name.toLowerCase().contains(query) || it.cuisine_type.toLowerCase()
                    .contains(query)
            }.flatMap {
                Observable.just(RestItemDetails(it.id.toString(), it.name))
            }
            .toList()
            .observeOn(Schedulers.computation()).zipWith(Observable.fromIterable(menu).filter {
                checkIfMenuCategoriesHasItem(it.categories, query)
            }.flatMap {
                Observable.just(
                        it.restaurantId
                    )
            }.toList().observeOn(Schedulers.computation())).subscribe(Consumer {
                val iterator = it.first.iterator()
                while(iterator.hasNext()){
                    val item = iterator.next()
                    if(it.second.contains(item.id.toInt())){
                        iterator.remove()
                    }
                }
                it.second.forEach { item->
                    it.first.add(RestItemDetails(item.toString(),getRestName(item,restaurant)))
                }
                searchData.postValue(it.first)
            }))
        return searchData

    }

    /**
     * check if query string matches the item
     */

    private fun checkIfMenuCategoriesHasItem(category: List<Category>, query: String): Boolean {
        category.forEach {
            if (it.name.toLowerCase().contains(query)) {
                return true
            }
        }

        return false
    }

    /**
     * dispose the observables
     */

    public fun dispose(){
        disposable.dispose()
    }

    private fun getRestName(id: Int, restaurant: List<Restaurant>): String {
        restaurant.forEach {
            if (it.id == id) {
                return it.name
            }
        }

        return ""
    }
}