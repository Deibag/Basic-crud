import { Route, Switch } from 'react-router-dom';
import './App.css';
import Main from './Components/Main';
import Update from './Components/Update'


function App() {
  return (
    <div className="App">
      <Switch>
        <Route exact path="/" component={Main} />
        <Route exact path="/update/:id" component={Update} />
      </Switch>
    </div>
  );
}

export default App;
