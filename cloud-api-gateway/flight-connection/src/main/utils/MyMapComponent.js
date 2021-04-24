import React from "react";
import ReactDOM from "react-dom";
import {
  withScriptjs,
  withGoogleMap,
  GoogleMap,
  Marker,
  google,
  Polyline
} from "react-google-maps";




export const MyMapComponent = props => {
  console.log(props.path);
  const arr = props.path;

  const pathCoordinates = [
    { lat: 36.052, lng: -112.083 },
    { lat: 36.216, lng: -112.056 }
  ];


  const InternalMap = () => (

    <GoogleMap defaultZoom={3} defaultCenter={{ lat: 25.276987, lng: 55.296249 }}>



      <Marker
        position={{
          lat: props.path[0].lat,
          lng: props.path[0].lng
        }}
        title={props.fromAirName}

        style={{ height: '2xpx', width: '2px' }}
      />
      <Marker
        position={{
          lat: props.path[1].lat,
          lng: props.path[1].lng
        }}

        style={{ height: '1xpx', width: '1px' }}
      />


      {props.path && props.path.length > 2 ?
        <Marker
          position={{
            lat: props.path[2].lat,
            lng: props.path[2].lng
          }}
          title={props.toAirName}

          style={{ height: '2xpx', width: '2px' }}
        /> : ""}

      <Polyline
        path={arr && arr.length > 0 ? arr : ""}
        geodesic={true}
        strokeColor='#00ffff'
        strokeOpacity={1.0}
        strokeWeight={2}
      />
    </GoogleMap>
  );


  const MapHoc = withScriptjs(withGoogleMap(InternalMap));

  return (
    <MapHoc
      googleMapURL="https://maps.googleapis.com/maps/api/js?key=AIzaSyBPGygadrhurg8G4jOQFo4PCcKk0Q6iqyk&libraries=geometry,drawing,places"
      loadingElement={<div style={{ height: `100%` }} />}
      containerElement={<div style={{ height: `400px` }} />}
      mapElement={<div style={{ height: `100%` }} />}
    />)

};

// ReactDOM.render(
//   <MyMapComponent />,
//   document.getElementById("root")
// );