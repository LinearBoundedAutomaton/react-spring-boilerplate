import * as React from "react";
import DefaultNavbar from "../../components/DefaultNavbar/DefaultNavbar";


const Home = () => {
    return (
        <>
            <header>
                <DefaultNavbar name={"Home"}/>
            </header>
            <main role="main">
                <div className="container text-center">
                    <h1>Homepage</h1>
                    <p className="text-muted">
                        This is a user's page.
                    </p>
                </div>
            </main>
        </>
    );
}

export default Home;