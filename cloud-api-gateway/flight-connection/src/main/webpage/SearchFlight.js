import React, { useState, useEffect } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';
import TextField from '@material-ui/core/TextField';
import Grid from "@material-ui/core/Grid";
import Button from '@material-ui/core/Button';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import axios from 'axios';
import clsx from 'clsx';
import FormControl from '@material-ui/core/FormControl';
import history from '../../history';
import validate from 'validate.js';
import { MyMapComponent } from "../utils/MyMapComponent";
import { baseUrl, masterDataServiceUrl, connectionBuilderServiceUrl, connectionBuilderServiceUrlForApplicableFlight, masterDataServiceUrlForAllAirport } from '../services/API';


let instance = axios.create({
  timeout: 10000,
});
const useStyles = makeStyles({
  root: {
    flexGrow: 1,
    backgroundColor: '#1261A0',
    paddingTop: '10px',
    // paddingBottom: '10px',
  },
  grids: {
    paddingTop: '20px',
    paddingLeft: '5%'
  },
  input: {
    height: 40
  },
  button: {
    backgroundColor: '#1261A0',
    height: 40
  },
  table: {
    minWidth: 650,
  },
  tableGrid: {
    paddingLeft: '5%',
    paddingRight: '5%',
    paddingTop: '2%'
  }
});

const schema = {
  fromAirport: {
    presence: {
      allowEmpty: false,
      message: 'is required',
    },
    format: {
      pattern: '[a-z][A-Z]*',
      flags: 'i',
      message: 'only characters are allowed',
    },
    length: {
      maximum: 3,
      minimum: 3
    },
  },
  toAirport: {
    presence: {
      allowEmpty: false,
      message: 'is required',
    },
    format: {
      pattern: '[a-z][A-Z]*',
      flags: 'i',
      message: 'only characters are allowed',
    },
    length: {
      maximum: 3,
      minimum: 3
    },
  }
}

const CenteredTabs = () => {
  const classes = useStyles();
  const InitialState = {
    values: {
      fromAirport: '',
      toAirport: '',
    },
    errors: {},
  };
  const [fromAir, setFromAir] = useState();
  const [fromAirName, setFromAirName] = useState();
  const [toAirName, settoAirName] = useState();
  const [toAir, settoAir] = useState();
  const [connectingAir, setconnectingAir] = useState();
  const [masterData, setMasterData] = useState([]);
  const [formState, setFormState] = useState(InitialState);
  const [applicableFlights, setapplicableFlights] = useState([]);
  const [mapCordinates, setMapCordinates] = useState([]);

  const handleSubmit = async () => {

    formState.values.fromAirport = fromAir;
    formState.values.toAirport = toAir;
    const errors = validate(formState.values, schema);
    setFormState((frmState) => ({
      ...frmState,
      isValid: !errors,
      errors: errors || {},
    }));

    if (errors) return;

    try {
      var userData1 = await axios.post(connectionBuilderServiceUrlForApplicableFlight, {
        depAirport: fromAir,
        arrAirport: toAir
      }, {
        headers: {
          "Access-Control-Allow-Origin": "*",
          "Content-type": "application/json; charset=UTF-8",
          Accept: "application/json"
        }
      }).then(({ data }) => setapplicableFlights(data.connectionData));

    }
    catch (err) {
      console.error(err.message);
    }


    applicableFlights.map((row, index) => {
      console.log(row.onwardArrArpt)
      setconnectingAir(row.onwardArrArpt)

    });

    const localArr = [];
    masterData.map((row, index) => {
      var cordinates;
      if (fromAir === row.airportCode) {
        cordinates = row.coordinates;
        var parts = cordinates.split(/[^\d\w]+/);

        var latValue = ConvertDMSToDD(parts[0], parts[1], parts[2], parts[3]);
        var lngValue = ConvertDMSToDD(parts[4], parts[5], parts[6], parts[7]);
        const arr = { lat: latValue, lng: lngValue };
        localArr.push(arr);

        setFromAirName(row.cityName);
      }
      if (connectingAir === row.airportCode) {

        cordinates = row.coordinates;
        var parts = cordinates.split(/[^\d\w]+/);

        var latValue = ConvertDMSToDD(parts[0], parts[1], parts[2], parts[3]);
        var lngValue = ConvertDMSToDD(parts[4], parts[5], parts[6], parts[7]);
        const arr = { lat: latValue, lng: lngValue };
        localArr.push(arr);

      }

      if (toAir === row.airportCode) {
        cordinates = row.coordinates;


        var parts = cordinates.split(/[^\d\w]+/);

        var latValue = ConvertDMSToDD(parts[0], parts[1], parts[2], parts[3]);
        var lngValue = ConvertDMSToDD(parts[4], parts[5], parts[6], parts[7]);
        const arr = { lat: latValue, lng: lngValue };
        localArr.push(arr);
        settoAirName(row.cityName);
      }

    }
    );
    setMapCordinates(localArr);


  };

  function ConvertDMSToDD(degrees, minutes, seconds, direction) {
    var dd = degrees + minutes / 60 + seconds / (60 * 60);
    dd = parseFloat(dd);
    if (direction == "S" || direction == "W") {
      dd = dd * -1;
    }
    return dd / 10;
  };
  useEffect(async () => {
    var masterDataResponse = await axios.get(masterDataServiceUrlForAllAirport, {
      headers: {
        "Access-Control-Allow-Origin": "*",
        "Content-type": "application/json; charset=UTF-8",
        Accept: "application/json"
      }
    }).then(({ data }) => setMasterData(data));

    console.log(masterData);

  }, []);

  const hasError = (field) => !!formState.errors[field];

  const handleChange = (label, event) => {
    event.persist();
    console.log(label, event.target.value)
    if (label == 'FromAirport') {
      setFromAir(event.target.value);
    }
    if (label == 'ToAirport') {
      settoAir(event.target.value);
    }
  };

  const handleRowClick = (rowData) => {

    const localArr = [];
    masterData.map((row, index) => {

      var cordinates;
      if (rowData.onwardDepArpt === row.airportCode) {

        if (fromAir === row.airportCode) {

          cordinates = row.coordinates;
          var parts = cordinates.split(/[^\d\w]+/);

          var latValue = ConvertDMSToDD(parts[0], parts[1], parts[2], parts[3]);
          var lngValue = ConvertDMSToDD(parts[4], parts[5], parts[6], parts[7]);
          const arr = { lat: latValue, lng: lngValue };
          localArr.push(arr);

          setFromAirName(row.cityName);
        }
      }
      if (rowData.onwardArrArpt === row.airportCode) {



        cordinates = row.coordinates;

        var parts = cordinates.split(/[^\d\w]+/);

        var latValue = ConvertDMSToDD(parts[0], parts[1], parts[2], parts[3]);
        var lngValue = ConvertDMSToDD(parts[4], parts[5], parts[6], parts[7]);
        const arr = { lat: latValue, lng: lngValue };
        localArr.push(arr);
        settoAirName(row.cityName);


      }
      if (rowData.connArrArpt === row.airportCode) {

        if (toAir === row.airportCode) {

          cordinates = row.coordinates;

          var parts = cordinates.split(/[^\d\w]+/);

          var latValue = ConvertDMSToDD(parts[0], parts[1], parts[2], parts[3]);
          var lngValue = ConvertDMSToDD(parts[4], parts[5], parts[6], parts[7]);
          const arr = { lat: latValue, lng: lngValue };
          localArr.push(arr);
          settoAirName(row.cityName);

        }
      }

    }
    );
    setMapCordinates(localArr);
  };


  return (
    <div>

      <Grid container direction="row" spacing="5" className={classes.grids} >
        <Grid item>
          <FormControl className={clsx(classes.margin, classes.textField)}>
            <TextField
              variant="outlined"
              id="outlined-basic"
              label="From Airport"
              name="fromAirport"
              //value={formState.values.fromAirport || ''}
              type="text"
              onChange={(e) => handleChange('FromAirport', e)}
              error={hasError('fromAirport')}
              helperText={
                hasError('fromAirport') ? formState.errors.fromAirport[0] : null
              }
              InputProps={{
                className: classes.input
              }}
              InputLabelProps={{
                shrink: true
              }}
              required
            // helperText="helper text"
            />
          </FormControl>
        </Grid>
        <Grid item>
          <FormControl className={clsx(classes.margin, classes.textField)}>
            <TextField
              variant="outlined"
              id="outlined-basic"
              label="To Airport"
              name="toAirport"
              type="text"
              onChange={(e) => handleChange('ToAirport', e)}
              error={hasError('toAirport')}
              helperText={
                hasError('toAirport') ? formState.errors.toAirport[0] : null
              }
              InputProps={{
                className: classes.input
              }}
              InputLabelProps={{
                shrink: true
              }}
              required
            // helperText="helper text"
            />
          </FormControl>
        </Grid>

        <Grid item>
          <Button
            variant="contained"
            color="primary"
            className={classes.button}
            size="large"
            onClick={handleSubmit}
          >
            Search
          </Button>
        </Grid>
      </Grid>

      <Grid item className={classes.tableGrid} >
        {applicableFlights && applicableFlights.length > 0 && (
          <TableContainer component={Paper}>
            <Table className={classes.table} aria-label="simple table">
              <TableHead>
                <TableRow>
                  <TableCell><strong>Onward Flight</strong></TableCell>
                  <TableCell align="right"><strong>Dep Airport</strong></TableCell>
                  <TableCell align="right"><strong>Arrival Airport</strong></TableCell>
                  <TableCell align="right"><strong>Dep Time</strong></TableCell>
                  <TableCell align="right"><strong>Arr Time</strong></TableCell>
                  <TableCell align="right"><strong>Connecting Flight</strong></TableCell>
                  <TableCell align="right"><strong>Dep Airport</strong></TableCell>
                  <TableCell align="right"><strong>Arrival Airport</strong></TableCell>
                  <TableCell align="right"><strong>Dep Time</strong></TableCell>
                  <TableCell align="right"><strong>Arr Time</strong></TableCell>
                </TableRow>
              </TableHead>

              <TableBody>
                {applicableFlights.map((row, index) => (
                  <TableRow key={index} onClick={() => handleRowClick(row)}>
                    <TableCell component="th" scope="row" >
                      {row.onwardFltNo}
                    </TableCell>
                    <TableCell align="right">{row.onwardDepArpt}</TableCell>
                    <TableCell align="right">{row.onwardArrArpt}</TableCell>
                    <TableCell align="right">{row.onwardDepTime}</TableCell>
                    <TableCell align="right">{row.onwardArrTime}</TableCell>
                    <TableCell align="right">{row.connFltNo}</TableCell>
                    <TableCell align="right">{row.connDepArpt}</TableCell>
                    <TableCell align="right">{row.connArrArpt}</TableCell>
                    <TableCell align="right">{row.connDepTime}</TableCell>
                    <TableCell align="right">{row.connArrTime}</TableCell>
                  </TableRow>
                ))}
              </TableBody>
            </Table>
          </TableContainer>)
        }
      </Grid>
      { applicableFlights && applicableFlights.length > 0 && (
        <Grid item className={classes.tableGrid} >
          <h1>Google Maps</h1>
          <MyMapComponent path={mapCordinates} fromAirName={fromAirName} toAirName={toAirName} />
        </Grid>
      )}
    </div>
  );
};
export default CenteredTabs;
