package com.example.expert.core.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.expert.core.domain.model.MovieModel
import com.example.expert.core.domain.repository.IMovieRepository
import com.example.expert.core.utils.DataMapper
import kotlinx.coroutines.flow.map

class MovieRepository(
    private val remoteDataSource: com.example.expert.core.data.source.remote.RemoteDataSource,
    private val localDataSource: com.example.expert.core.data.source.local.LocalDataSource
) :
    IMovieRepository {

    override fun getAllMovies() =
        remoteDataSource.getAllMovies().map { DataMapper.mapResponsesToDomain(it) }

    override fun getMovieDetail(id: Int) =
        remoteDataSource.getMovieDetail(id).map { DataMapper.mapResponseToDomain(it) }

    override fun getFavoriteMovies() = localDataSource.getFavorite().map { DataMapper.mapEntitiesToDomain(it) }

    override fun checkFavoriteMovie(id: Int): LiveData<Boolean> {
        val liveData = MutableLiveData<Boolean>()
        localDataSource.check(id, object : com.example.expert.core.data.source.local.LocalDataSource.CheckFavoriteCallback{
            override fun onChecked(entity: com.example.expert.core.data.source.local.entity.id?) {
                if (entity?.id == id) liveData.postValue(true)
                else liveData.postValue(false)
            }
        })
        return liveData
    }

    override fun insertMovie(movie: MovieModel) = localDataSource.insert(DataMapper.mapDomainToEntity(movie))

    override fun deleteMovie(movie: MovieModel) = localDataSource.delete(DataMapper.mapDomainToEntity(movie))

    override fun getMovieDetails(id: Int) = remoteDataSource.getMovieDetail(id).map { DataMapper.mapResponseToDomain(it) }

}