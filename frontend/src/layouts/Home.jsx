import signinLogo from "../assets/images/signin.png";
import signupLogo from "../assets/images/signup.png";
import AppCard from "../components/AppCard";
import styles from "./Home.module.css";

const Home = () => {
    return (
        <>
            <h1 className={`text-center ${styles.app_heading} mt-3`}>
                This is Home Component
            </h1>
            <div className="app-control container text-center position-absolute top-50 start-50 translate-middle mt-4">
                <div className="row">
                    {/* Sign-in Card */}
                    <div className="col align-self-start">
                        <AppCard
                            text={"Sign-in to SKIO"}
                            cardLogo={signinLogo}
                            route={"/signin"}
                        />
                    </div>
                    {/* Sign-up Card */}
                    <div className="col align-self-start">
                        <AppCard
                            text={"Sign-up to SKIO"}
                            cardLogo={signupLogo}
                            route={"/signup"}
                        />
                    </div>
                </div>
            </div>
        </>
    );
};

export default Home;
