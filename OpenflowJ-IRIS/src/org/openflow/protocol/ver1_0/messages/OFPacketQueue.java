package org.openflow.protocol.ver1_0.messages;

import java.nio.ByteBuffer;
import org.openflow.util.*;

import java.util.List;
import java.util.LinkedList;
import org.openflow.protocol.ver1_0.types.*;

public class OFPacketQueue    {
    public static int MINIMUM_LENGTH = 8;

    int  queue_id;
	short  length;
	short pad_1th;
	List<OFQueueProperty>  properties;

    public OFPacketQueue() {
        this.properties = new LinkedList<OFQueueProperty>();
    }
    
    public OFPacketQueue(OFPacketQueue other) {
    	this.queue_id = other.queue_id;
		this.length = other.length;
		this.properties = (other.properties == null)? null: new LinkedList<OFQueueProperty>();
		for ( OFQueueProperty i : other.properties ) { this.properties.add( new OFQueueProperty(i) ); }
    }

	public int getQueueId() {
		return this.queue_id;
	}
	
	public OFPacketQueue setQueueId(int queue_id) {
		this.queue_id = queue_id;
		return this;
	}
			
	public short getLength() {
		return this.length;
	}
	
	public OFPacketQueue setLength(short length) {
		this.length = length;
		return this;
	}
			
	public List<OFQueueProperty> getProperties() {
		return this.properties;
	}
	
	public OFPacketQueue setProperties(List<OFQueueProperty> properties) {
		this.properties = properties;
		return this;
	}
			

    public void readFrom(ByteBuffer data) {
        int mark = data.position();
		this.queue_id = data.getInt();
		this.length = data.getShort();
		this.pad_1th = data.getShort();
		if (this.properties == null) this.properties = new LinkedList<OFQueueProperty>();
		int __cnt = ((int)getLength() - (data.position() - mark));
		while (__cnt > 0) {
		  data.mark();
		  short __t = data.getShort();
		  data.reset();
		  OFQueueProperty t = OFQueuePropertyType.valueOf(__t).newInstance();
		  t.readFrom(data); __cnt -= t.getLength();
		  this.properties.add(t);
		}
    }

    public void writeTo(ByteBuffer data) {
    	
        data.putInt(this.queue_id);
		data.putShort(this.length);
		data.putShort(this.pad_1th);
		if (this.properties != null ) for (OFQueueProperty t: this.properties) { t.writeTo(data); }
    }

    public String toString() {
        return  ":OFPacketQueue-"+":queue_id=" + U32.f(queue_id) + 
		":length=" + U16.f(length) + 
		":properties=" + properties.toString();
    }

	// compute length (without final alignment)    
    public short computeLength() {
    	short len = (short)MINIMUM_LENGTH;
    	for ( OFQueueProperty i : this.properties ) { len += i.computeLength(); }
    	return len;
    }
    
    // calculate the amount that will be increased by the alignment requirement.
    public short alignment(short req) {
    	short l = (short)(computeLength() % req);
    	if ( l == 0 ) { return 0; }
    	return (short)( req - l );
    }
    
    // compute the difference with MINIMUM_LENGTH (with alignment)
    public short lengthDiff() {
    	return (short)(computeLength() - (short)MINIMUM_LENGTH + alignment((short)0));
    }

    @Override
    public int hashCode() {
        		
		final int prime = 2473;
		int result = super.hashCode() * prime;
		result = prime * result + (int) queue_id;
		result = prime * result + (int) length;
		result = prime * result + ((properties == null)?0:properties.hashCode());
		return result;
    }

    @Override
    public boolean equals(Object obj) {
        
		if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof OFPacketQueue)) {
            return false;
        }
        OFPacketQueue other = (OFPacketQueue) obj;
		if ( queue_id != other.queue_id ) return false;
		if ( length != other.length ) return false;
		if ( properties == null && other.properties != null ) { return false; }
		else if ( !properties.equals(other.properties) ) { return false; }
        return true;
    }
}
