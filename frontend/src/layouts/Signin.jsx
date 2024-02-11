import { AiOutlineLogin } from "react-icons/ai";
import styles from "./Signin.module.css";

const SignIn = () => {
    return (
        <div className="login-container container">
            <h1 className={`${styles.signin_head} text-center`}>
                Sign-In Component
            </h1>
            <div
                className={`${styles.loginForm} position-absolute top-50 start-50 translate-middle border border-3 rounded-1 border-opacity-50`}
            >
                <form className="mx-auto px-3 py-3" method="POST">
                    <div className="mb-3">
                        <label className="form-label">Email address</label>
                        <input
                            type="email"
                            className="form-control"
                            id="exampleInputEmail1"
                            aria-describedby="emailHelp"
                        />
                        <div id="emailHelp" className="form-text">
                            We&apos;ll never share your email with anyone else.
                        </div>
                    </div>
                    <div className="mb-3">
                        <label className="form-label">Password</label>
                        <input
                            type="password"
                            className="form-control"
                            id="exampleInputPassword1"
                        />
                    </div>
                    <div className="d-grid gap-2 col-6 mx-auto">
                        <button
                            type="submit"
                            className="btn btn-lg btn-outline-success"
                        >
                            LOGIN &nbsp; <AiOutlineLogin />
                        </button>
                    </div>
                </form>
            </div>
        </div>
    );
};

export default SignIn;
