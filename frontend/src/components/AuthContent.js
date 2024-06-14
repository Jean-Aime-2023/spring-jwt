// AuthContent.js
import { request } from '../axios_helper';
import * as React from 'react';

export default class AuthContent extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      data: [],
    };
  }

  componentDidMount() {
    request('GET', '/messages', {})
      .then((response) => {
        console.log(response.data);
        if (Array.isArray(response.data)) {
          this.setState({ data: response.data });
        } else {
          console.error('Data received is not an array');
        }
      })
      .catch((error) => {
        console.error('There was an error!', error);
      });
  }

  render() {
    return (
      <div className="row justify-content-md-center">
        <div className="col-4">
          <div className="card" style={{ width: '18rem' }}>
            <div className="card-body">
              <h5 className="card-title">Backend Reponse</h5>
              <p>Content:</p>
              <ul>
                {this.state.data.map((line, index) => (
                  <li key={index}>{line}</li>
                ))}
              </ul>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
