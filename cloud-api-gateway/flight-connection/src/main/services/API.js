import axios from 'axios';

export const baseUrl = 'http://localhost:8089/';
export const masterDataServiceUrl = `${baseUrl}master-data-service/`;
export const connectionBuilderServiceUrl = `${baseUrl}connection-builder-service/`;
export const connectionBuilderServiceUrlForApplicableFlight = `${connectionBuilderServiceUrl}api/flightconnections`;
export const masterDataServiceUrlForAllAirport = `${masterDataServiceUrl}api/airports`;

