IRIS
====
IRIS (pronounced ai-ri-s) is the Openflow-based Resursive SDN Openflow Controller created by SDN Research Section, ETRI.

In Greek mythodology, Iris is the goddess of the rainbow as well as the messenger of the other gods. 
We named our controller after Iris in the hopes of creating a control plane architecture 
that can effectively deliver network policies to the underlying data plane.

Technically, IRIS is built on Beacon-like NIO-based event handler. On top of the IO engine, 
we have ported many of Floodlight core/application modules including Learning Switch, 
Link Discovery, Topology Manager, Device Manager, Forwarding, Firewall, and Static Flow Entry Pusher.
Further, we have enhanced the Firewall module, and newly introduced a Nettwork Failover Module. 

Though a large portion of the IRIS functions take after those of Floodlight and Beacon, 
we did not want to stop at merely creating an improved version of the famous open-source controllers. 
Our vision was to create an SDN controller platform with the following features 
(* not all of these are to be included in the open-source IRIS):

1. Horizontal Scalability for carrier-grade network
2. High Availability with transparent failover from failure
3. Multi-domain support with recursive network abstraction based on Openflow

We strived to satisfy above qualities with much simpler architecture 
that facilitates developers to comfortably use and customize. 
To do so, we have re-factored Floodlight a lot, successfully simplifying it to give better performance 
and maintain an easy-to-learn development model. Further, IRIS REST API is designed to be fully compliant 
with that of Floodlight, so that the current Floodlight applications can be easily transferred to IRIS.

We have also modified the basic Floodlight UI to give users an easier view of the network topology. 
Some of its improvements in the IRIS UI enable zoom-in, zoom-out, and panning of the network topology.

Specification
-------------

1. Supports Openflow 1.0.1 ~ 1.3.2
2. Pure Java-based Implementation
3. Handles more than 5 million Mac Learning Requests per second with commodity HW
4. Supports about 500 concurrent connections to switches with commodity HW
5. The same license policy with Floodlight (Apache license)
6. Loxigen-based Openflow API

Authors
-------
Byungjoon Lee (byungjoon.lee@gmail.com) 
* GitHub ID: bjlee72 
* Senior Researcher 
* SDN Technology Research Devision, ETRI 
* Key Interests are: Software Engineering, SDN, Network Management, ICN

Jisoo Shin (jshin@etri.re.kr) 
* GitHub ID: jsshin 
* Senior Researcher 
* SDN Technology Research Devision, ETRI 
* Key Interests are: SDN, Network Management

Sae Hyong Park (labry@etri.re.kr) 
* GitHub ID: justin-labry 
* Researcher 
* SDN Technology Research Devision, ETRI 
* Key Interests are: SDN, Network Management


