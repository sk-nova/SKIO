import { useState } from "react";
import Badge from "react-bootstrap/Badge";
import Card from "react-bootstrap/Card";
import styles from "./UserTypeCard.module.css";

const UserTypeCard = ({ userTypeTitle, userTypeIcon, getUserType }) => {
    const [typeActive, setTypeActive] = useState(false);

    const myFunc = () => {
        setTypeActive(!typeActive);
        getUserType(userTypeTitle);
    };

    return (
        <>
            <Card
                onClick={myFunc}
                style={{ width: "18rem" }}
                className={`${styles.userTypeBox} ${
                    typeActive
                        ? "active border border-4 border-info-subtle"
                        : ""
                }`}
            >
                <Card.Body>
                    <Card.Title>
                        <Badge bg="info">{userTypeTitle.toUpperCase()}</Badge>
                    </Card.Title>
                    <Card.Img variant="top" src={userTypeIcon} />
                </Card.Body>
            </Card>
        </>
    );
};

export default UserTypeCard;
