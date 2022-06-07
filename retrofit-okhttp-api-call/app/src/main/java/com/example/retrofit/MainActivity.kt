package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var retrofitInstance : AlbumService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        retrofitInstance = RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)
        //getRequestQueryParameters()
        //getRequestPathParameters()
        uploadAlbum()
    }

    fun getRequestQueryParameters(){
        val pathParameter : LiveData<Response<AlbumsItem>> = liveData {
            emit(retrofitInstance.getAlbum(4))
        }

        pathParameter.observe(this,Observer{
            val album = it.body()?.title
            Toast.makeText(this,album,Toast.LENGTH_LONG).show()
        })
    }
    fun getRequestPathParameters(){
        val retrofitLiveData: LiveData<Response<Albums>> = liveData {
            emit(retrofitInstance.getSelectedAlbums(3))
        }
        retrofitLiveData.observe(this, Observer {
            val albumsList = it.body()?.listIterator()
            if(albumsList!= null){
                while (albumsList.hasNext()){
                    val albumsItem = albumsList.next()
                    val result = " "+ "Title: ${albumsItem.title}"+"\n"+
                            " "+ "Album Id: ${albumsItem.id}"+"\n"+
                            " "+ "User Id: ${albumsItem.userId}"+"\n\n\n"
                    findViewById<TextView>(R.id.text_View).append(result)
                }
            }
        })
    }
    fun uploadAlbum(){
        val album = AlbumsItem(0,"Album 4",3)
        val retrofitLiveData: LiveData<Response<AlbumsItem>> = liveData {
            emit(retrofitInstance.uploadAlbum(album))
        }
        retrofitLiveData.observe(this, Observer {
            val albumsItem = it.body()
            val result = " "+ "Title: ${albumsItem?.title}"+"\n"+
                    " "+ "Album Id: ${albumsItem?.id}"+"\n"+
                    " "+ "User Id: ${albumsItem?.userId}"+"\n\n\n"
            findViewById<TextView>(R.id.text_View).text = result
        })
    }
}