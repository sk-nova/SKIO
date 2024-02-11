import axios from "axios";

const BASE_URL = "http://localhost:8005";
const USERTYPE_URL = `${BASE_URL}/api/test`;

class HttpCommons {
    getAllUserTypes() {
        return axios.get(USERTYPE_URL);
    }
}

export default HttpCommons;
