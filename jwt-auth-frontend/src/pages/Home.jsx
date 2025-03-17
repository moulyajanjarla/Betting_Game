import { useState } from 'react';
import LoginForm from '../components/LoginForm';
import RegisterForm from '../components/RegisterForm';

const Home = ({ onLogin }) => {
  return (
    <div>
      <h1>Welcome to Betting App</h1>
      <LoginForm onLogin={onLogin} />
      <RegisterForm />
    </div>
  );
};

export default Home;
