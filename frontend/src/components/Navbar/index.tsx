import './styles.css';
import { ReactComponent as GithubIcon } from '../../assets/img/github.svg';

export function Navbar() {

    return (
        <header>
        <nav className="container">
          <div className="movie-nav-content">
            <h1>Movie</h1>
            <a href="https://github.com/youssfbr">
              <div className="movie-contact-container">
                <GithubIcon />
                <p className="movie-contact-link">/youssfbr</p>
              </div>
            </a>
          </div>
        </nav>
      </header>    
    );
}