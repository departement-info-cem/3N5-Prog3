package org.depinfo.videorecyclerviewdiffutil.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.depinfo.videorecyclerviewdiffutil.databinding.MovieItemBinding
import org.depinfo.videorecyclerviewdiffutil.models.Movie

class MovieAdapter : ListAdapter<Movie, MovieAdapter.MovieItemViewHolder>(MovieItemDiffCallback) {

    inner class MovieItemViewHolder(private val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.tvName.text = movie.name
            binding.tvYear.text = movie.year.toString()
            binding.tvDirector.text = movie.director
            binding.cbVu.isChecked = movie.vu

            // Quand on clique pour cocher ou décocher si on a vu un film
            binding.cbVu.setOnCheckedChangeListener { _, isChecked ->
                // Copier la liste de films
                val newList = currentList.toMutableList().map { it.copy() }.toMutableList()

                // Trouver l'index du film sur lequel on a cliqué
                val currentMovieIndex = newList.indexOfFirst { it.id == movie.id }

                // Trouver le film à partir de l'index utilisé
                val currentMovie = newList[currentMovieIndex]

                // Inverser l'état de vu de l'objet film sur lequel on a cliqué
                currentMovie.vu = isChecked

                // Mettre à jour la liste copiée
                newList[currentMovieIndex] = currentMovie

                // Envoyer la liste à l'adapteur pour être affichée
                submitList(newList)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val binding: MovieItemBinding =
            MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

object MovieItemDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(avant: Movie, apres: Movie): Boolean {
        return avant.id == apres.id
    }

    override fun areContentsTheSame(avant: Movie, apres: Movie): Boolean {
        return avant.id == apres.id
            && avant.name == apres.name
            && avant.year == apres.year
            && avant.director == apres.director
            && avant.vu == apres.vu
    }
}