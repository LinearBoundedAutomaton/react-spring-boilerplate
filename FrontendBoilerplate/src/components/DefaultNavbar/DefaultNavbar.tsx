import * as React from "react";
import { Link } from "react-router-dom";

interface NavEntry {
    name : string,
    link : string,
}

const entries : NavEntry[] = [
    {
        name: "Index",
        link: "/",
    },
    {
        name: "Login",
        link: "/login",
    },
    {
        name: "Home",
        link: "/homepage",
    }
];

export interface DefaultNavbarProps {
    name? : string,
}

const DefaultNavbar = (props : DefaultNavbarProps) => {
    let NavItems : JSX.Element[] = [];
    entries.forEach((el)=>{
        if(props.name){
            if(props.name === el.name){
                NavItems.push(
                    <div className="nav-item active" key={el.name + "navitem"}>
                        <Link to={el.link} className="nav-link" >{el.name}</Link>
                    </div>
                );
            } else {
                NavItems.push(
                    <div className="nav-item" key={el.name + "navitem"}>
                        <Link to={el.link}  className="nav-link" >{el.name}</Link>
                    </div>
                );
            }
        } else {
            NavItems.push(
                <div className="nav-item" key={el.name + "navitem"}>
                    <Link to={el.link}  className="nav-link" >{el.name}</Link>
                </div>
            );
        }
    });
    return (
        <div className="navbar navbar-expand-lg navbar-light bg-light">
            <div className="container-fluid">
                <div className="collapse navbar-collapse" id="navbarNav">
                    <div className="navbar-nav">
                        {NavItems}
                    </div>
                </div>
            </div>
        </div>
    );
}

export default DefaultNavbar;