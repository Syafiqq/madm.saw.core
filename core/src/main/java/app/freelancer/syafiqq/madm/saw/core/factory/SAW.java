package app.freelancer.syafiqq.madm.saw.core.factory;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * This <saw> project in package <app.freelancer.syafiqq.madm.saw.core.factory> created by :
 * Name         : syafiq
 * Date / Time  : 10 April 2017, 4:28 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class SAW
{
    private @NotNull  List<Alternative> alternatives;
    private @Nullable ProfitContainer   profit;
    private @Nullable WeightContainer   weight;

    public SAW()
    {
        this.alternatives = new LinkedList<>();
    }

    public void process()
    {
        this.compile();
        this.searchProfit();
        this.calculate();
        this.ranking();
        this.sort();
    }

    private void compile()
    {
        if(this.alternatives.size() <= 0)
        {
            System.err.println("At least one alternative exists");
            System.exit(0);
        }

        this.profit = alternatives.get(0).adaptToProfit();
        if(this.profit == null)
        {
            System.err.println("Profit Container must be initialized");
            System.exit(0);
        }

        if(this.weight == null)
        {
            System.err.println("Weight Container must be initialized");
            System.exit(0);
        }
    }

    private void searchProfit()
    {
        for(Alternative alternative : this.alternatives)
        {
            this.profit.searchProfits(alternative);
        }
    }

    private void calculate()
    {
        for(Alternative alternative : this.alternatives)
        {
            alternative.calculateNormalization(this.profit);
        }
    }

    private void ranking()
    {
        for(Alternative alternative : this.alternatives)
        {
            alternative.calculatePreferences(this.weight);
        }
    }

    private void sort()
    {
        Collections.sort(this.alternatives, new Comparator<Alternative>()
        {
            @Override
            public int compare(Alternative a1, Alternative a2)
            {
                return a1.compareTo(a2);
            }
        });
    }

    @Nullable public Alternative getBestAlternative()
    {
        @Nullable Alternative best = null;
        if(alternatives.size() > 0)
        {
            @NotNull final Alternative first = this.alternatives.get(0);
            @NotNull final Alternative last  = this.alternatives.get(this.alternatives.size() - 1);
            best = first.compareTo(last) >= 0 ? last : first;
        }
        else
        {
            System.err.println("At least one alternative exists");
            System.exit(0);
        }
        return best;
    }

    public boolean addAlternative(@NotNull Alternative t)
    {
        return alternatives.add(t);
    }

    @NotNull public List<Alternative> getAlternatives()
    {
        return this.alternatives;
    }

    @Nullable public ProfitContainer getProfit()
    {
        return this.profit;
    }

    public void setProfit(@NotNull ProfitContainer profit)
    {
        this.profit = profit;
    }

    @Nullable public WeightContainer getWeight()
    {
        return this.weight;
    }

    public void setWeight(@NotNull WeightContainer weight)
    {
        this.weight = weight;
    }

    @Override public String toString()
    {
        final StringBuilder sb = new StringBuilder("SAW{");
        sb.append("alternatives=").append(alternatives);
        sb.append(", profit=").append(profit);
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }
}
