(this["webpackJsonpflight-connection"]=this["webpackJsonpflight-connection"]||[]).push([[0],{215:function(t,e,r){},216:function(t,e,r){},442:function(t,e,r){"use strict";r.r(e);var a=r(0),n=r.n(a),i=r(9),c=r.n(i),o=(r(215),r(216),r(200)),s=r(11),l=r(73),p=r.n(l),j=r(130),h=r(126),d=r(31),g=r(480),b=r(485),u=r(494),O=r(483),x=r(486),m=r(488),f=r(492),A=r(491),v=r(487),w=r(489),y=r(490),C=r(70),k=r.n(C),N=r(3),T=r(496),F=(r(26).a(),r(197)),S=r.n(F),D=r(44),G=r(4),P=function(t){console.log(t.path);var e=t.path,r=Object(D.withScriptjs)(Object(D.withGoogleMap)((function(){return Object(G.jsxs)(D.GoogleMap,{defaultZoom:3,defaultCenter:{lat:25.276987,lng:55.296249},children:[Object(G.jsx)(D.Marker,{position:{lat:t.path[0].lat,lng:t.path[0].lng},title:t.fromAirName,style:{height:"2xpx",width:"2px"}}),Object(G.jsx)(D.Marker,{position:{lat:t.path[1].lat,lng:t.path[1].lng},style:{height:"1xpx",width:"1px"}}),t.path&&t.path.length>2?Object(G.jsx)(D.Marker,{position:{lat:t.path[2].lat,lng:t.path[2].lng},title:t.toAirName,style:{height:"2xpx",width:"2px"}}):"",Object(G.jsx)(D.Polyline,{path:e&&e.length>0?e:"",geodesic:!0,strokeColor:"#00ffff",strokeOpacity:1,strokeWeight:2})]})})));return Object(G.jsx)(r,{googleMapURL:"https://maps.googleapis.com/maps/api/js?key=AIzaSyBPGygadrhurg8G4jOQFo4PCcKk0Q6iqyk&libraries=geometry,drawing,places",loadingElement:Object(G.jsx)("div",{style:{height:"100%"}}),containerElement:Object(G.jsx)("div",{style:{height:"400px"}}),mapElement:Object(G.jsx)("div",{style:{height:"100%"}})})},M="http://localhost:8089/",E="".concat(M,"master-data-service/"),I="".concat(M,"connection-builder-service/"),L="".concat(I,"api/flightconnections"),q="".concat(E,"api/airports"),z=(k.a.create({timeout:1e4}),Object(g.a)({root:{flexGrow:1,backgroundColor:"#1261A0",paddingTop:"10px"},grids:{paddingTop:"20px",paddingLeft:"5%"},input:{height:40},button:{backgroundColor:"#1261A0",height:40},table:{minWidth:650},tableGrid:{paddingLeft:"5%",paddingRight:"5%",paddingTop:"2%"}})),B={fromAirport:{presence:{allowEmpty:!1,message:"is required"},format:{pattern:"[a-z][A-Z]*",flags:"i",message:"only characters are allowed"},length:{maximum:3,minimum:3}},toAirport:{presence:{allowEmpty:!1,message:"is required"},format:{pattern:"[a-z][A-Z]*",flags:"i",message:"only characters are allowed"},length:{maximum:3,minimum:3}}},U=function(){var t=z(),e=Object(a.useState)(),r=Object(d.a)(e,2),n=r[0],i=r[1],c=Object(a.useState)(),o=Object(d.a)(c,2),s=o[0],l=o[1],g=Object(a.useState)(),C=Object(d.a)(g,2),F=C[0],D=C[1],M=Object(a.useState)(),E=Object(d.a)(M,2),I=E[0],U=E[1],W=Object(a.useState)(),Z=Object(d.a)(W,2),J=Z[0],Q=Z[1],R=Object(a.useState)([]),H=Object(d.a)(R,2),K=H[0],V=H[1],X=Object(a.useState)({values:{fromAirport:"",toAirport:""},errors:{}}),Y=Object(d.a)(X,2),$=Y[0],_=Y[1],tt=Object(a.useState)([]),et=Object(d.a)(tt,2),rt=et[0],at=et[1],nt=Object(a.useState)([]),it=Object(d.a)(nt,2),ct=it[0],ot=it[1],st=function(){var t=Object(h.a)(p.a.mark((function t(){var e,r;return p.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:if($.values.fromAirport=n,$.values.toAirport=I,e=S()($.values,B),_((function(t){return Object(j.a)(Object(j.a)({},t),{},{isValid:!e,errors:e||{}})})),!e){t.next=6;break}return t.abrupt("return");case 6:return t.prev=6,t.next=9,k.a.post(L,{depAirport:n,arrAirport:I},{headers:{"Access-Control-Allow-Origin":"*","Content-type":"application/json; charset=UTF-8",Accept:"application/json"}}).then((function(t){var e=t.data;return at(e.connectionData)}));case 9:t.sent,t.next=15;break;case 12:t.prev=12,t.t0=t.catch(6),console.error(t.t0.message);case 15:rt.map((function(t,e){console.log(t.onwardArrArpt),Q(t.onwardArrArpt)})),r=[],K.map((function(t,e){if(n===t.airportCode){var a={lat:lt((c=t.coordinates.split(/[^\d\w]+/))[0],c[1],c[2],c[3]),lng:lt(c[4],c[5],c[6],c[7])};r.push(a),l(t.cityName)}if(J===t.airportCode){var i={lat:lt((c=t.coordinates.split(/[^\d\w]+/))[0],c[1],c[2],c[3]),lng:lt(c[4],c[5],c[6],c[7])};r.push(i)}if(I===t.airportCode){var c,o={lat:lt((c=t.coordinates.split(/[^\d\w]+/))[0],c[1],c[2],c[3]),lng:lt(c[4],c[5],c[6],c[7])};r.push(o),D(t.cityName)}})),ot(r);case 19:case"end":return t.stop()}}),t,null,[[6,12]])})));return function(){return t.apply(this,arguments)}}();function lt(t,e,r,a){var n=t+e/60+r/3600;return n=parseFloat(n),"S"!=a&&"W"!=a||(n*=-1),n/10}Object(a.useEffect)(Object(h.a)(p.a.mark((function t(){return p.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.next=2,k.a.get(q,{headers:{"Access-Control-Allow-Origin":"*","Content-type":"application/json; charset=UTF-8",Accept:"application/json"}}).then((function(t){var e=t.data;return V(e)}));case 2:t.sent,console.log(K);case 4:case"end":return t.stop()}}),t)}))),[]);var pt=function(t){return!!$.errors[t]},jt=function(t,e){e.persist(),console.log(t,e.target.value),"FromAirport"==t&&i(e.target.value),"ToAirport"==t&&U(e.target.value)};return Object(G.jsxs)("div",{children:[Object(G.jsxs)(O.a,{container:!0,direction:"row",spacing:"5",className:t.grids,children:[Object(G.jsx)(O.a,{item:!0,children:Object(G.jsx)(T.a,{className:Object(N.a)(t.margin,t.textField),children:Object(G.jsx)(u.a,{variant:"outlined",id:"outlined-basic",label:"From Airport",name:"fromAirport",type:"text",onChange:function(t){return jt("FromAirport",t)},error:pt("fromAirport"),helperText:pt("fromAirport")?$.errors.fromAirport[0]:null,InputProps:{className:t.input},InputLabelProps:{shrink:!0},required:!0})})}),Object(G.jsx)(O.a,{item:!0,children:Object(G.jsx)(T.a,{className:Object(N.a)(t.margin,t.textField),children:Object(G.jsx)(u.a,{variant:"outlined",id:"outlined-basic",label:"To Airport",name:"toAirport",type:"text",onChange:function(t){return jt("ToAirport",t)},error:pt("toAirport"),helperText:pt("toAirport")?$.errors.toAirport[0]:null,InputProps:{className:t.input},InputLabelProps:{shrink:!0},required:!0})})}),Object(G.jsx)(O.a,{item:!0,children:Object(G.jsx)(x.a,{variant:"contained",color:"primary",className:t.button,size:"large",onClick:st,children:"Search"})})]}),Object(G.jsx)(O.a,{item:!0,className:t.tableGrid,children:rt&&rt.length>0&&Object(G.jsx)(v.a,{component:b.a,children:Object(G.jsxs)(m.a,{className:t.table,"aria-label":"simple table",children:[Object(G.jsx)(w.a,{children:Object(G.jsxs)(y.a,{children:[Object(G.jsx)(A.a,{children:Object(G.jsx)("strong",{children:"Onward Flight"})}),Object(G.jsx)(A.a,{align:"right",children:Object(G.jsx)("strong",{children:"Dep Airport"})}),Object(G.jsx)(A.a,{align:"right",children:Object(G.jsx)("strong",{children:"Arrival Airport"})}),Object(G.jsx)(A.a,{align:"right",children:Object(G.jsx)("strong",{children:"Dep Time"})}),Object(G.jsx)(A.a,{align:"right",children:Object(G.jsx)("strong",{children:"Arr Time"})}),Object(G.jsx)(A.a,{align:"right",children:Object(G.jsx)("strong",{children:"Connecting Flight"})}),Object(G.jsx)(A.a,{align:"right",children:Object(G.jsx)("strong",{children:"Dep Airport"})}),Object(G.jsx)(A.a,{align:"right",children:Object(G.jsx)("strong",{children:"Arrival Airport"})}),Object(G.jsx)(A.a,{align:"right",children:Object(G.jsx)("strong",{children:"Dep Time"})}),Object(G.jsx)(A.a,{align:"right",children:Object(G.jsx)("strong",{children:"Arr Time"})})]})}),Object(G.jsx)(f.a,{children:rt.map((function(t,e){return Object(G.jsxs)(y.a,{onClick:function(){return function(t){var e=[];K.map((function(r,a){if(t.onwardDepArpt===r.airportCode&&n===r.airportCode){var i={lat:lt((o=r.coordinates.split(/[^\d\w]+/))[0],o[1],o[2],o[3]),lng:lt(o[4],o[5],o[6],o[7])};e.push(i),l(r.cityName)}if(t.onwardArrArpt===r.airportCode){var c={lat:lt((o=r.coordinates.split(/[^\d\w]+/))[0],o[1],o[2],o[3]),lng:lt(o[4],o[5],o[6],o[7])};e.push(c),D(r.cityName)}if(t.connArrArpt===r.airportCode&&I===r.airportCode){var o,s={lat:lt((o=r.coordinates.split(/[^\d\w]+/))[0],o[1],o[2],o[3]),lng:lt(o[4],o[5],o[6],o[7])};e.push(s),D(r.cityName)}})),ot(e)}(t)},children:[Object(G.jsx)(A.a,{component:"th",scope:"row",children:t.onwardFltNo}),Object(G.jsx)(A.a,{align:"right",children:t.onwardDepArpt}),Object(G.jsx)(A.a,{align:"right",children:t.onwardArrArpt}),Object(G.jsx)(A.a,{align:"right",children:t.onwardDepTime}),Object(G.jsx)(A.a,{align:"right",children:t.onwardArrTime}),Object(G.jsx)(A.a,{align:"right",children:t.connFltNo}),Object(G.jsx)(A.a,{align:"right",children:t.connDepArpt}),Object(G.jsx)(A.a,{align:"right",children:t.connArrArpt}),Object(G.jsx)(A.a,{align:"right",children:t.connDepTime}),Object(G.jsx)(A.a,{align:"right",children:t.connArrTime})]},e)}))})]})})}),rt&&rt.length>0&&Object(G.jsxs)(O.a,{item:!0,className:t.tableGrid,children:[Object(G.jsx)("h1",{children:"Google Maps"}),Object(G.jsx)(P,{path:ct,fromAirName:s,toAirName:F})]})]})},W=r(495),Z=r(493),J=Object(g.a)({root:{flexGrow:1,backgroundColor:"#1261A0",paddingTop:"10px",paddingBottom:"10px"},images:{width:"100%",height:window.innerHeight},about:{width:"100%",height:"600px"}}),Q=function(){var t=J(),e=n.a.useState(0),r=Object(d.a)(e,2),a=r[0],i=r[1];return Object(G.jsx)("div",{children:Object(G.jsx)(b.a,{className:t.root,children:Object(G.jsx)(W.a,{value:a,onChange:function(t,e){i(e)},indicatorColor:"primary",centered:!0,children:Object(G.jsx)(Z.a,{label:"Search Flights",href:"/",style:{color:"white",fontSize:"16px"}})})})})};var R=function(){return Object(G.jsx)("div",{className:"App",children:Object(G.jsx)(o.a,{children:Object(G.jsxs)(s.c,{children:[Object(G.jsx)(s.a,{exact:!0,path:"/",component:U}),Object(G.jsx)(s.a,{exact:!0,path:"/manageFlights",component:Q})]})})})},H=function(t){t&&t instanceof Function&&r.e(3).then(r.bind(null,497)).then((function(e){var r=e.getCLS,a=e.getFID,n=e.getFCP,i=e.getLCP,c=e.getTTFB;r(t),a(t),n(t),i(t),c(t)}))};c.a.render(Object(G.jsx)(n.a.StrictMode,{children:Object(G.jsx)(R,{})}),document.getElementById("root")),H()}},[[442,1,2]]]);
//# sourceMappingURL=main.5408704a.chunk.js.map