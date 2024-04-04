import React, { useState, useEffect } from 'react';
import axios from 'axios';

function UserList() {
  const [userList, setUserList] = useState([]);
  const [isLoading, setIsLoading] = useState(true);
  useEffect(() => {
    axios.get('/rp/react/user')
    .then(res => {
      console.log(res.data);
      setUserList(res.data);
      setIsLoading(false);
    })
    .catch(err => {console.log(err);});
  },[]);
  return (
    <div>
      <h1>User List</h1>
      <h3>{isLoading ? '로딩중...' : ''}</h3>
      <table border={1}>
          <tr>
            <th>UID</th>
            <th>Name</th>
            <th>regDate</th>
            <th>profile</th>
          </tr>
          {userList.map(user => (
            <tr key={user.uid}>
              <td>{user.uid}</td>
              <td>{user.name}</td>
              <td>{user.regdate}</td>
              <td>{user.profile}</td>
            </tr>
          ))}
      </table>
    </div>
  );
}

export default UserList;
