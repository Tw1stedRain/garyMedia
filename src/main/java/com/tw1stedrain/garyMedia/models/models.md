# Models

## Series

A series has a top level look at multiple movies or tv seasons that go together. With a `OneToMany` relationship to either one, a single series can contain all the moveies that belong to a series or all the seasons that belong to a single show.

### Movies

Movies have a `ManyToOne` realtionship to a series, along with all needed infromation about that movie in particular.

  * `title` 
  * `coverArt`
  * `durationInMinutes`
  * `releaseDate`
  * `actors`
  * `dvdOrBluRay`
  * `genre`
  * `rating`
  * `indbLink`
  * `rottenTomatoes`
  * `loaned`

### Tv Season

  * `title` 
  * `coverArt`
  * `numOfEpisodes`
  * `releaseDate`
  * `actors`
  * `genre`
  * `rating`
  * `indbLink`
  * `rottenTomatoes`
  * `loaned`
