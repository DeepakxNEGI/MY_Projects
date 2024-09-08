import { useState } from 'react';
import './App.css';
import EmailSender from './Components/EmailSender';
import { Toaster } from 'react-hot-toast'; // Import Toaster

function App() {
  const [count, setCount] = useState(0);

  return (
    <>
      <EmailSender />
      <Toaster /> {/* Include Toaster */}
    </>
  );
}

export default App;
