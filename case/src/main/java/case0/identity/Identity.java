package case0.identity;

import factory.Properties;
import org.apache.commons.lang3.builder.ToStringBuilder;

/*
 * This <saw> project in package <case2.identity> created by : 
 * Name         : syafiq
 * Date / Time  : 10 April 2017, 8:15 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class Identity extends Properties
{
    private String option;

    public Identity(String option)
    {
        this.option = option;
    }

    public String getOption()
    {
        return option;
    }

    public void setOption(String option)
    {
        this.option = option;
    }

    @Override public String toString()
    {
        return new ToStringBuilder(this)
                .append("option", option)
                .toString();
    }
}
