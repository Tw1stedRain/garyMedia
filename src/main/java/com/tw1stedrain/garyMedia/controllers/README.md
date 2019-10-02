# Controllers

## Series Controller

All routes contained in the `SeriesController` are preceded by a `/series`.

### Routes

TBD

## Movie Controller

All routes contained in the `MovieController` are preceded by a `/movies`.

### Routes

* `/allmovies` - displays all movies in your collection. Will have the functionality for the user to sort collection by movie title, rating, duration, or genre. 

* `/moviedetail/{id}` - displays the movies information in full detail. This is also where the user is able to mark if the movie is currently loaned out. 

* `/newmovie` - a form at the top of the collection page gives the user the ability to add a new movie to their collection.

* `/update/{id}` - gives the user the ability to update the information stored about a single movie. This is also where the user will have a chance to add the movie to an already existing series.

* `/movie/{id}` - deletes the movie from the users collection.

## Tv Season Controller

All routes contained in the `TvController` are preceded by a `/tv`.

### Routes

* `/allTv` - displays all tv seasons in your collection. Will have to functionality for the user to sort collection by season title, rating, number of episodes, or genre.

* `/seasonDetail{id}` - displays the seaons information in full detail. This is where the user is able to mark if the season is currently loaned out.

* `/newSeason` - a form at the top of the season collection page that gives the user the ability to add a new season to their collection.

* `/update/{id}` - gives the user the ability to update the information stored about a single season. This is also where the user will have a chance to add a season to an already existing series.

* `/season/{id}` - deletes the season from the users collection.

## Actor Controller

All routes contained in the `ActorController` are preceded by a `/actors`.

### Routes

* `/allActors` - displays all actors in your collection. Will have to functionality for the user to sort collection by actor first name or last name.

* `/actorDetail{id}` - displays the actor's information in full detail. This is where the user is able to mark if the actor is now dead.

* `/newActor` - a form at the top of the actor collection page that gives the user the ability to add a new actor to their collection.

* `/update/{id}` - gives the user the ability to update the information stored about a single actor.

* `/actor/{id}` - deletes the actor from the users collection.
