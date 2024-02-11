import { useState } from "react";
import Button from "react-bootstrap/Button";
import Modal from "react-bootstrap/Modal";
import devIcon from "../assets/images/dev_icon.png";
import leadDevIcon from "../assets/images/lead_dev_icon.png";
import mgrIcon from "../assets/images/manager_icon.png";
import qaIcon from "../assets/images/tester_icon.png";
import UserTypeCard from "./UserTypeCard";

function MyModal(props) {
    const [userType, setUserType] = useState("");

    const userTypeSubmit = () => {
        props.onHide();
        props.getUserType(userType);
    };

    // Callback Function to get User Type from User Types
    const getUserType = (uType) => {
        setUserType(uType);
    };

    return (
        <Modal
            backdrop={props.backdrop}
            keyboard={props.keyboard}
            show={props.show}
            onHide={props.onHide}
            // {...props}
            size="lg"
            aria-labelledby="contained-modal-title-vcenter"
            centered
        >
            <Modal.Header closeButton>
                <Modal.Title id="contained-modal-title-vcenter">
                    User Type
                </Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <h4>Please Select Type</h4>
                <div className="userType mx-2 my-4">
                    <div className="container overflow-hidden text-center">
                        <div className="row">
                            <div className="col-6">
                                <div className="p-3">
                                    <UserTypeCard
                                        key={"Developer"}
                                        userTypeTitle="Developer"
                                        userTypeIcon={devIcon}
                                        getUserType={getUserType}
                                    />
                                </div>
                            </div>
                            <div className="col-6">
                                <div className="p-3">
                                    <UserTypeCard
                                        key={"Tester"}
                                        userTypeTitle="Tester"
                                        userTypeIcon={qaIcon}
                                        getUserType={getUserType}
                                    />
                                </div>
                            </div>
                            <div className="col-6">
                                <div className="p-3">
                                    <UserTypeCard
                                        key={"Project Manager"}
                                        userTypeTitle={"Project Manager"}
                                        userTypeIcon={mgrIcon}
                                        getUserType={getUserType}
                                    />
                                </div>
                            </div>
                            <div className="col-6">
                                <div className="p-3">
                                    <UserTypeCard
                                        key={"Project Lead"}
                                        userTypeTitle={"Project Lead"}
                                        userTypeIcon={leadDevIcon}
                                        getUserType={getUserType}
                                    />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </Modal.Body>
            <Modal.Footer>
                <Button variant="outline-primary" onClick={userTypeSubmit}>
                    Confirm User
                </Button>
            </Modal.Footer>
        </Modal>
    );
}

export default MyModal;
