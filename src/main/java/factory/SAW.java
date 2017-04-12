package factory;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * This <saw> project in package <factory> created by : 
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

    public void compile()
    {
        if(alternatives.size() > 0)
        {
            this.profit = alternatives.get(0).adaptToProfit();
            for(@NotNull final Alternative alternative : this.alternatives)
            {
                this.profit.searchProfits(alternative);
            }
        }
        else
        {
            System.err.println("At least one alternative exists");
            System.exit(0);
        }
    }

    public void calculate()
    {
        if(alternatives.size() > 0)
        {
            for(@NotNull final Alternative alternative : this.alternatives)
            {
                alternative.calculateNormalization(this.profit);
            }
        }
        else
        {
            System.err.println("At least one alternative exists");
            System.exit(0);
        }
    }

    public void ranking()
    {
        if(alternatives.size() > 0)
        {
            for(@NotNull final Alternative alternative : this.alternatives)
            {
                alternative.calculatePreferences(this.weight);
            }
        }
        else
        {
            System.err.println("At least one alternative exists");
            System.exit(0);
        }
    }

    public void sort()
    {
        this.alternatives.sort(Comparator.naturalOrder());
    }

    public void process()
    {
        this.compile();
        this.calculate();
        this.ranking();
        this.sort();
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
}
