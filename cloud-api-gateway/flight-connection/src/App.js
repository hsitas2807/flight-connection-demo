import './App.css';
import React from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import SearchFlight from './main/webpage/SearchFlight';
import ManageFlights from './main/manageFlights/ManageFlights';


function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
          <Route exact path="/" component={SearchFlight} />
          <Route exact path="/manageFlights" component={ManageFlights} />
        </Switch>
      </Router>
    </div>
  );
}

export default App;
