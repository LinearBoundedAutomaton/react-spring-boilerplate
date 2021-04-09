import * as React from "react";
import DefaultNavbar from "../../components/DefaultNavbar/DefaultNavbar";


const Login = () => {
    let errored : boolean = false;
    let queryParams = new URLSearchParams(window.location.search);
    if(queryParams.has("error")){
        if(queryParams.get("error") === "true"){
            errored = true;
        }
    }
    let submitLogin = (event : React.FormEvent) => {
        event.preventDefault();
        console.log(event.target)
        //@ts-ignore
        console.log(event.target[0]);
        //@ts-ignore
        console.log(event.target[1]);
        const formData = new FormData();
        const fileField = document.querySelector('input[type="file"]');

        formData.append('username', 'abc123');
        formData.append('password', "pass");
        fetch(
            "./login",
            {
                method: 'POST',
                body: "",
            }
        ).then(
            (response) => {
                console.log(response)
            }
        ).catch(
            (error) => {
                console.log(error);
            }
        );
    }
    let errorMessage : JSX.Element[] = [];
    if(errored === true){
        errorMessage.push(
            <div key={"erroronloginmessage"}>
                Failed to login!
            </div>
        );
    }
    return (
        <div>
            <header>
                <DefaultNavbar name={"Login"}/>
            </header>
            <main>
                <div className="container text-center">
                    <form action="/SpringBoilerplate/perform_login" method="post">
                        <h1>Login</h1>
                        <div className="form-group row">
                            <label htmlFor="input-username" className="col-sm-2 col-form-label">Username</label>
                            <div className="col-sm-10">
                                <input type="text" name="username" id="input-username" className="form-control"></input>
                            </div>
                        </div>
                        <div className="form-group row">
                            <label htmlFor="input-password" className="col-sm-2 col-form-label">Password</label>
                            <div className="col-sm-10">
                                <input type="password" name="password" id="input-password" className="form-control"></input>
                            </div>
                        </div>
                        <button className="w-100 btn btn-lg btn-primary" type="submit">Login</button>
                        {errorMessage}
                    </form>
                </div>
            </main>
        </div>
    );
}

export default Login;