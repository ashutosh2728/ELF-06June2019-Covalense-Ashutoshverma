import React, { Component } from 'react'
import Axios from 'axios'

export class Login extends Component {
   constructor(props){
      super(props);

      this.state = {
          id : '',
          password : '',
          errorMessage: ''
      }

      this.postLoginData = this.postLoginData.bind(this);
  }

  postLoginData(event) {
      event.preventDefault();
      //let accountData = this.state;
      const {id,password} = this.state;
      const loginData = {id,password};

      if(this.validateLogin(loginData)){
          //Call the API using Axios and Validate the Employee Login
          Axios.post('http://localhost/emp-springrest/login/auth',null,{
              params:{
                  id:this.state.id,
                  password:this.state.password
              }
          }).then((response)=>{
              console.log(response.data);
              console.log(response.data.statusCode)
              if(response.statusCode==401){
                  this.setState({errorMessage:response.data.message});
              } else{
                  
                              }
          }).catch((error)=>{
              console.log('Error',error);
          });
      }
  }

  validateLogin(loginData){
      let validationSuccess = false;

      if(loginData.id.trim()==="" || loginData.id.trim()===null){
          alert('Please enter Employee Id');
          document.getElementById("id").focus();
          return validationSuccess;
      } else if(loginData.password.trim()==="" || loginData.password.trim()===null){
          alert('Please enter Password');
          document.getElementById("password").focus();
          return validationSuccess;
      } else{
          validationSuccess = true;
      }

      return validationSuccess;
  }
    render() {
        return (
           <div > 

            <div class="sidenav">
         <div class="login-main-text">
            <h2>E-Library<br/> Login Page </h2>
            <p>Login or register from here to access.</p>
      </div>
      </div >
      <div class="main">
         <div class="col-md-6 col-sm-12">
            <div class="login-form">
               <form onSubmit={this.postLoginData}>
                  <div class="form-group">
                     <label>User ID</label>
                     <input type="text" onChange={(event)=>{this.setState({id:event.target.value})}} value={this.state.id} class="form-control" placeholder="User ID"/>
                  </div>
                  <div class="form-group">
                     <label>Password</label>
                     <input type="password" onChange={(event)=>{this.setState({password:event.target.value})}} value={this.state.password} class="form-control" placeholder="Password"/>
                  </div>
                  <button type="submit" class="btn btn-black">Login</button>
                  <a href="">  Forgot-Password</a>
               </form>
            </div>
         </div>
      </div>
      </div>
      
        )
    }
}

export default Login

