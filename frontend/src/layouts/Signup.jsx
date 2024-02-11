import { useState } from "react";
import MyModal from "../components/MyModal";
import validateUserType from "../utils/UserTypeUtils";
import styles from "./Signup.module.css";

const SignUp = () => {
    const [modalShow, setModalShow] = useState(false);
    const [userTypeField, setUserTypeField] = useState("");

    // state to manage user types
    const [userTypes, setUserStyle] = useState([]);

    // Sign up Submission Handler
    const signUpFormSubmitHandler = (event) => {
        event.preventDefault();
        if (validateUserType(userTypeField)) {
            console.log("Validate fields");
        } else setModalShow(true);
    };

    // Callback function to receive User Type
    const getUserType = (usertype) => {
        setUserTypeField(usertype);
    };

    // set the buttons to show
    let btns;
    if (!validateUserType(userTypeField)) {
        btns = (
            <button
                type="submit"
                className="btn btn-lg btn-outline-success"
                data-bs-toggle="modal"
                data-bs-target="#exampleModal"
            >
                SIGNUP
            </button>
        );
    } else {
        btns = (
            <>
                <button
                    className="btn btn-lg btn-outline-secondary"
                    data-bs-toggle="modal"
                    data-bs-target="#exampleModal"
                >
                    CHANGE USER TYPE
                </button>
                <button
                    type="submit"
                    className="btn btn-lg btn-outline-success"
                >
                    SIGNUP
                </button>
            </>
        );
    }

    return (
        <div className="login-container container">
            <h1 className={`${styles.signup_head} text-center`}>
                Sign-Up Component
            </h1>
            <div
                className={`${styles.signupForm} position-absolute top-50 start-50 translate-middle border border-3 rounded-1 border-opacity-50 mt-5`}
            >
                <form
                    className="mx-auto px-3 py-3"
                    onSubmit={signUpFormSubmitHandler}
                    method="POST"
                >
                    <div className="mb-3">
                        <label className="form-label">First Name</label>
                        <input
                            type="text"
                            className="form-control"
                            id="firstName"
                            aria-describedby="emailHelp"
                            name="firstName"
                        />
                        <label className="form-label">Last Name</label>
                        <input
                            type="text"
                            className="form-control"
                            id="lastName"
                            aria-describedby="emailHelp"
                            name="lastName"
                        />
                        <label className="form-label">Email address</label>
                        <input
                            type="email"
                            className="form-control"
                            id="userEmail"
                            aria-describedby="emailHelp"
                            name="userEmail"
                        />
                        <label className="form-label">Contact No</label>
                        <input
                            type="number"
                            className="form-control"
                            id="contactNo"
                            aria-describedby="emailHelp"
                            name="contactNo"
                        />
                        {/* <div id="emailHelp" className="form-text">
                            We&apos;ll never share your email with anyone else.
                        </div> */}
                    </div>
                    <div className="mb-3">
                        <label className="form-label">Password</label>
                        <input
                            type="password"
                            className="form-control"
                            id="userPwd"
                            name="userPwd"
                        />
                    </div>
                    <div className="mb-3">
                        <label className="form-label">Confirm Password</label>
                        <input
                            type="password"
                            className="form-control"
                            id="userConfPwd"
                            name="userConfPwd"
                        />
                    </div>
                    <div className="mb-3">
                        <label className="form-label">User Type</label>
                        <input
                            type="text"
                            className="form-control"
                            id="userType"
                            name="userType"
                            placeholder={userTypeField}
                            disabled
                        />
                    </div>
                    <div className="d-grid gap-2 col-6 mx-auto">{btns}</div>
                </form>
                <MyModal
                    backdrop="static"
                    keyboard={false}
                    show={modalShow}
                    onHide={() => setModalShow(false)}
                    getUserType={getUserType}
                />
            </div>
        </div>
    );
};

export default SignUp;
