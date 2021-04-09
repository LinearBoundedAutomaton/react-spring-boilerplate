import * as React from "react";
import DefaultNavbar from "../../components/DefaultNavbar/DefaultNavbar";


const Index = () => {
    return (
        <>
            <header>
                <DefaultNavbar name={"Index"}/>
            </header>
            <main role="main">
                <div className="container text-center">
                    <h1>Homepage</h1>
                    <p className="text-muted">
                        This is the homepage.
                    </p>
                </div>
            </main>
        </>
    );
}

export default Index;