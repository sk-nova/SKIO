import { createBrowserRouter } from "react-router-dom";
import App from "../App";
import ErrorPage from "../layouts/ErrorPage";
import Home from "../layouts/Home";
import SignIn from "../layouts/Signin";
import SignUp from "../layouts/Signup";
const router = createBrowserRouter([
    {
        path: "/",
        element: <App />,
        errorElement: <ErrorPage />,
    },
    {
        path: "/home",
        element: <Home />,
    },
    {
        path: "/signin",
        element: <SignIn />,
    },
    {
        path: "/signup",
        element: <SignUp />,
    },
]);

export default router;
