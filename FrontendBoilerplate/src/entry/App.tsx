import * as React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import Index from "../pages/Index/Index";
import NotFound from "../pages/NotFound/NotFound";
import Login from "../pages/Login/Login";
import Home from "../pages/Home/Home";

const App = () => {
    return (
        <React.Suspense fallback={<div>Loading...</div>}>
            <BrowserRouter basename="/SpringBoilerplate">
                <Switch>
                    <Route path="/" exact component={Index}/>
                    <Route path="/login" component={Login}/>
                    <Route path="/homepage" component={Home}/>
                    <Route component={NotFound} exact/>
                </Switch>
            </BrowserRouter>
        </React.Suspense>
    );
}

export default App;