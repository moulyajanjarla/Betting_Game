import { useEffect, useState } from 'react';
import { getProtectedData } from '../services/authService';

const Protected = ({ token }) => {
  const [data, setData] = useState('');

  useEffect(() => {
    if (token) {
      getProtectedData(token)
        .then(setData)
        .catch((err) => console.error(err));
    }
  }, [token]);

  return (
    <div>
      <h2>Protected Data</h2>
      <pre>{data}</pre>
    </div>
  );
};

export default Protected;
