import { MdDoubleArrow } from "react-icons/md";
import { Link } from "react-router-dom";
import styles from "./Intro.module.css";

const Intro = () => {
    return (
        <>
            <div className="intro position-absolute top-50 start-50 translate-middle text-center px-5 py-5 border border-success p-2 mb-2 border-opacity-50">
                <h1 className={`text-center ${styles.intro_heading}`}>SKIO</h1>
                <p>A Simple Bug Tracking App</p>
                <p>Lets get started</p>
                <Link
                    className="btn btn-lg btn-outline-secondary mt-4"
                    to="/home"
                >
                    GO <MdDoubleArrow />
                </Link>
            </div>
        </>
    );
};

export default Intro;
