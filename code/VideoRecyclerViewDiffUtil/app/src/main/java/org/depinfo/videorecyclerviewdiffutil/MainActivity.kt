package org.depinfo.videorecyclerviewdiffutil

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import org.depinfo.videorecyclerviewdiffutil.adapters.MovieAdapter
import org.depinfo.videorecyclerviewdiffutil.databinding.ActivityMainBinding
import org.depinfo.videorecyclerviewdiffutil.models.Movie

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecycler()
        fillRecycler()
    }

    private fun setupRecycler() {
        adapter = MovieAdapter()
        binding.rvMovie.adapter = adapter
        binding.rvMovie.setHasFixedSize(true)
        binding.rvMovie.addItemDecoration(
            DividerItemDecoration(
                binding.rvMovie.context, DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun fillRecycler() {
        val items: List<Movie> = listOf(
            Movie(
                id = 1,
                name = "La vrai nature de Bernadette",
                year = 1972,
                director = "Gilles Carle",
                vu = false
            ),
            Movie(
                id = 2,
                name = "Les ordres",
                year = 1974,
                director = "Michel Brault",
                vu = false
            ),
            Movie(
                id = 3,
                name = "Pour la suite du monde",
                year = 1963,
                director = "Pierre Perrault, Michel Brault",
                vu = false
            ),
            Movie(
                id = 4,
                name = "C.R.A.Z.Y",
                year = 2005,
                director = "Jean-Marc Vallée",
                vu = false
            ),
            Movie(
                id = 5,
                name = "Le party",
                year = 1990,
                director = "Pierre Falardeau",
                vu = false
            ),
            Movie(
                id = 6,
                name = "Québec-Montréal",
                year = 2002,
                director = "Ricardo Trogi",
                vu = false
            ),
            Movie(
                id = 7,
                name = "Simple comme sylvain",
                year = 2023,
                director = "Monia Chokri",
                vu = false
            ),
            Movie(
                id = 8,
                name = "Mommy",
                year = 2014,
                director = "Xavier Dolan",
                vu = false
            )
        )
        adapter.submitList(items)
    }
}