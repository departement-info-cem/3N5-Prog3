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

            // Quand on clique pour cocher ou décocher si on a vu un film
            binding.cbVu.setOnCheckedChangeListener { _, isChecked ->
                // Copier la liste de films
                val currentList = currentList.toMutableList()

                // Trouver l'index du film sur lequel on a cliqué
                val currentMovieIndex = currentList.indexOfFirst { it.id == movie.id }

                // Trouver le film à partir de l'index utilisé
                val currentMovie = currentList[currentMovieIndex]

                // Inverser l'état de vu de l'objet film sur lequel on a cliqué
                currentMovie?.vu = isChecked

                // Mettre à jour la liste copiée
                currentList[currentMovieIndex] = currentMovie

                // Envoyer la liste à l'adapteur pour être affichée
                submitList(currentList)
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
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.name == newItem.name && oldItem.year == newItem.year && oldItem.director == newItem.director && oldItem.vu == newItem.vu
    }
}