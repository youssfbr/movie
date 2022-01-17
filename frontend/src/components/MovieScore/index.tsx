import "./styles.css";
import MovieStarts from "components/MovieStars";

type Props = {
  score: number;
  count: number;
}

function MovieScore({ score, count }: Props) {

  return (
    <div className="movie-score-container">
      <p className="movie-score-value">{score > 0 ? score.toFixed(1) : "-"}</p>
      <MovieStarts score={score} />
      <p className="movie-score-count">{count} avaliações</p>
    </div>
  );
}

export default MovieScore;
