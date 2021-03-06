/*L
 *  Copyright SAIC, Ellumen and RSNA (CTP)
 *
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/national-biomedical-image-archive/LICENSE.txt for details.
 */

package gov.nih.nci.nbia.dynamicsearch.criteria;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class StartWithCriteriaFactory implements CriteriaFactory {

	public Criterion constructCriteria(String fieldName, String value, String fieldType)
	throws Exception{
		
		if (value.equalsIgnoreCase("Not Populated (NULL)"))
		{
			value="null";
		}
		if ((fieldName.indexOf("SOPInstanceUID")>1)||
		   (fieldName.indexOf("acquisitionDatetime")>1)||
		   (fieldName.indexOf("SOPClassUID")>1))
		{
			return Restrictions.like(fieldName, value, MatchMode.START);
		}
		return Restrictions.ilike(fieldName, value, MatchMode.START);
	}

}
