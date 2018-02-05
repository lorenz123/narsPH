package com.lorenzinc.NarsPH;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GalleryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GalleryFragment extends Fragment {

    private final String TAG = this.getClass().getSimpleName();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public GalleryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GalleryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GalleryFragment newInstance(String param1, String param2) {
        GalleryFragment fragment = new GalleryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_gallery, container, false);

        final ArrayList<Product> products = new ArrayList<>();
        Product p1 = new Product("Cocaine", 100, 1000.25);
        Product p2 = new Product("MJ", 200, 1300.25);
        Product p3 = new Product("Kush", 1300, 50.25);
        Product p4 = new Product("Hush", 1040, 500.25);
        Product p5 = new Product("Liquid", 1050, 4000.25);
        Product p6 = new Product("Stone", 160, 20.25);

        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p6);

        BindDictionary<Product> dictionary = new BindDictionary<>();
        dictionary.addStringField(R.id.tvName, new StringExtractor<Product>() {
            @Override
            public String getStringValue(Product product, int position) {
                return product.getName();
            }
        });
        dictionary.addStringField(R.id.tvQty, new StringExtractor<Product>() {
            @Override
            public String getStringValue(Product product, int position) {
                return "" + product.getQty();
            }
        });
        dictionary.addStringField(R.id.tvPrice, new StringExtractor<Product>() {
            @Override
            public String getStringValue(Product product, int position) {
                return "" + product.getPrice();
            }
        });

        FunDapter adapter = new FunDapter(GalleryFragment.this.getActivity(), products, R.layout.product_layout, dictionary);

//        ArrayAdapter<Product> adapter = new ArrayAdapter<Product>(
//                GalleryFragment.this.getActivity(),
//                android.R.layout.simple_list_item_1,
//                products);

        ListView lvProduct = (ListView)view.findViewById(R.id.lvProduct);
        lvProduct.setAdapter(adapter);
        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product selectedProect = products.get(position);
                Toast.makeText(GalleryFragment.this.getActivity(), selectedProect.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;

    }

}
