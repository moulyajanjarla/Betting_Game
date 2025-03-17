import axios from 'axios';

const API_URL = 'http://localhost:8080/auth';

export const register = async (username, password) => {
  const response = await axios.post(`${API_URL}/register`, { username, password });
  return response.data;
};

export const login = async (username, password) => {
  const response = await axios.post(`${API_URL}/login`, { username, password });
  return response.data;
};

export const getProtectedData = async (token) => {
  const response = await axios.get('http://localhost:8080/api/bets', {
    headers: {
      Authorization: `Bearer ${token}`
    }
  });
  return response.data;
};
