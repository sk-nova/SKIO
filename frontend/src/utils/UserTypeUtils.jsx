function validateUserType(userType) {
    if (userType.length === 0 || userType === null || userType === undefined)
        return false;
    else return true;
}

export default validateUserType;
