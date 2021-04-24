import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';

const useStyles = makeStyles({
  root: {
    flexGrow: 1,
    backgroundColor: '#1261A0',
    paddingTop: '10px',
    paddingBottom: '10px',
  },

  images: {
    width: '100%',
    height: window.innerHeight,
  },

  about: {
    width: '100%',
    height: '600px',
  },
});

const CenteredTabs = () => {
  const classes = useStyles();
  const [value, setValue] = React.useState(0);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  return (
    <div>
      <Paper className={classes.root}>
        <Tabs
          value={value}
          onChange={handleChange}
          indicatorColor="primary"
          //textColor="primary"
          centered
        >
          {/* <Tab label="Home" style={{ color: 'white', fontSize: '16px' }} />
          <Tab label="About" style={{ color: 'white', fontSize: '16px' }} /> */}
          <Tab
            label="Search Flights"
            href="/"
            style={{ color: 'white', fontSize: '16px' }}
          />
        </Tabs>
      </Paper>

    </div>
  );
};
export default CenteredTabs;
