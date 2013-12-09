package org.openflow.protocol.ver1_3.messages;

import java.nio.ByteBuffer;
import org.openflow.util.*;

import java.util.List;
import java.util.LinkedList;
import org.openflow.protocol.ver1_3.types.*;

public class OFTableFeaturePropertyApplyActions extends OFTableFeatureProperty  {
    public static int MINIMUM_LENGTH = 4;

    List<OFActionId>  action_ids;

    public OFTableFeaturePropertyApplyActions() {
        super();
		setLength(U16.t(MINIMUM_LENGTH));
		setType(OFTableFeaturePropertyType.valueOf((short)6));
		this.action_ids = new LinkedList<OFActionId>();
    }
    
    public OFTableFeaturePropertyApplyActions(OFTableFeaturePropertyApplyActions other) {
    	super(other);
		this.action_ids = (other.action_ids == null)? null: new LinkedList<OFActionId>();
		for ( OFActionId i : other.action_ids ) { this.action_ids.add( new OFActionId(i) ); }
    }

	public List<OFActionId> getActionIds() {
		return this.action_ids;
	}
	
	public OFTableFeaturePropertyApplyActions setActionIds(List<OFActionId> action_ids) {
		this.action_ids = action_ids;
		return this;
	}
			

    public void readFrom(ByteBuffer data) {
        int mark = data.position();
		super.readFrom(data);
		if (this.action_ids == null) this.action_ids = new LinkedList<OFActionId>();
		int __cnt = ((int)getLength() - (data.position() - mark));
		while (__cnt > 0) { OFActionId t = new OFActionId(); t.readFrom(data); this.action_ids.add(t); __cnt -= t.getLength(); }
    }

    public void writeTo(ByteBuffer data) {
    	super.writeTo(data);
        if (this.action_ids != null ) for (OFActionId t: this.action_ids) { t.writeTo(data); }
    }

    public String toString() {
        return super.toString() +  ":OFTableFeaturePropertyApplyActions-"+":action_ids=" + action_ids.toString();
    }

	// compute length (without final alignment)    
    public short computeLength() {
    	short len = (short)MINIMUM_LENGTH;
    	for ( OFActionId i : this.action_ids ) { len += i.computeLength(); }
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
        		
		final int prime = 1747;
		int result = super.hashCode() * prime;
		result = prime * result + ((action_ids == null)?0:action_ids.hashCode());
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
        if (!(obj instanceof OFTableFeaturePropertyApplyActions)) {
            return false;
        }
        OFTableFeaturePropertyApplyActions other = (OFTableFeaturePropertyApplyActions) obj;
		if ( action_ids == null && other.action_ids != null ) { return false; }
		else if ( !action_ids.equals(other.action_ids) ) { return false; }
        return true;
    }
}
