import { Link } from "react-router-dom";
import styles from "./AppCard.module.css";

const AppCard = ({ text, cardLogo, route }) => {
    return (
        <div className="card shadow-lg p-3 mb-5 bg-body-tertiary rounded">
            <img
                src={cardLogo}
                className={`card-img-top my-3 ${styles.app_card_logo}`}
                alt="..."
            />
            <Link
                to={route}
                className={`card-body btn btn-outline-secondary ${styles.nav_link}`}
            >
                <p className="card-text">{text}</p>
            </Link>
        </div>
    );
};

export default AppCard;
