import "./styles.css";
import MovieStarts from "components/MovieStars";

function MovieScore() {
  const score = 3.5;
  const count = 13;

  return (
    <div className="movie-score-container">
      <p className="movie-score-value">{score > 0 ? score.toFixed(1) : "-"}</p>
      <MovieStarts />
      <p className="movie-score-count">{count} avaliações</p>
    </div>
  );
}

export default MovieScore;
