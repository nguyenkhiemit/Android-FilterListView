# Android-FilterListView

Create a auto complete on listview: <br>

class CustomFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults results = new FilterResults();
            if(charSequence != null && charSequence.length() > 0) {
                charSequence = charSequence.toString().toUpperCase();
                ArrayList<Person> filters = new ArrayList<>();
                for(int i = 0; i < filterArray.size(); i++) {
                    if(filterArray.get(i).getName().toUpperCase().contains(charSequence)) {
                        Person person = new Person(filterArray.get(i).getName(), filterArray.get(i).getImg());
                        filters.add(person);
                    }
                }
                results.count = filters.size();
                results.values = filters;
            } else {
                results.count = filterArray.size();
                results.values = filterArray;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {
            arrayPerson = (ArrayList<Person>)results.values;
            notifyDataSetChanged();
        }
    }
