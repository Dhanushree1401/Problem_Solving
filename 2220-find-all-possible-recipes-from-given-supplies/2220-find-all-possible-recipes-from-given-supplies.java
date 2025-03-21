class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) 
    {
        List<String> res = new ArrayList<String>();
		Set<String> stock = new HashSet<>(Arrays.asList(supplies));
		boolean flag=true;
		
		do {
			flag=false;
			
			for(int i=0;i<recipes.length;i++)
			{
				if(!stock.contains(recipes[i]))
				{
					List<String> ing = ingredients.get(i);
				
					int x=0;
					for(int j=0;j<ing.size();j++)
					{
						if(!stock.contains(ing.get(j)))
						{
							x=1;
							break;
						}
					}			
					
					if(x==0) 
					{
                        flag=true;
                        
						res.add(recipes[i]);
						stock.add(recipes[i]);
					}
				}
			}
		}while(flag);
		
		return res;
    }
}