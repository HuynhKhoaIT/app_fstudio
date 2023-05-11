package com.example.applestore.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.applestore.Adapter.CategoryAdapter;
import com.example.applestore.Adapter.ProductAdapter;
import com.example.applestore.R;
import com.example.applestore.model.Category;
import com.example.applestore.model.Product;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private ImageSlider imageSlider;
    private RecyclerView mRecyclerView,categoryRec;

    public HomeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
//        Ánh xạ
        imageSlider = view.findViewById(R.id.imageSlide);
        categoryRec = view.findViewById(R.id.categoryList);
        mRecyclerView = view.findViewById(R.id.product_list);


        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        //        list Category
        List<Category> categories = new ArrayList<>();
        Category category1 = new Category(1,"data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAoHCBUVEhESERIREREREhEREREREREPEQ8RGBQaGRgUGBgcIS4lHB4rHxgYJjgmKy8xNTU2GiU7QDs0Py40NTEBDAwMEA8QGhISGjQhISExMTE0MTQ0NDE0NDExMTQ0NDE0NDQ0NDQ0NDQxNDQxNDQ0MTQ0MTE0NDQxNDQxNDQ1NP/AABEIALcBEwMBIgACEQEDEQH/xAAbAAACAgMBAAAAAAAAAAAAAAAAAQIDBAUGB//EAEYQAAIBAgMEBgMMCAUFAAAAAAECAAMRBBIhBTFBUQYTYXGBkSJSsRQjJDJCcnOhssHR8AcVNFRiY5KTFjNDU+FEdKKjs//EABoBAQADAQEBAAAAAAAAAAAAAAABAgMFBAb/xAAkEQEBAAIBBAIDAAMAAAAAAAAAAQIDERIhMTIiUQQTQTNCYf/aAAwDAQACEQMRAD8A2iiTEYEmBOU6KF4wZK0LQFEDJWhaAiYR2gBAQMDHaPLAgYCTtERAV4jGVlbOBvIHeQIEoC0r6xfWX+oRdYvrL5iOEcrSYGVdYvrL5iBqL6w8xHCVl4wZR1i+sPMSWcesPMQLdJKVprJCA7Rx2iywEBHaO0AICtFaSgBAUVpPLFlgAELQtGBAgyyJWW5ZBhArtCTywgTAjkQ4jzCBKFos0d4BaELwvALQgYoDtHFeF4BFAyJMCeBoioXdjakjFAB/qOPjX7AdLdhmR+ssKj9V1lBHBy5M4FmvbKbaBr8N8xMDnGDpgei7JUIPFah3G/zm3zj32cuU3FrcCLAAb7zsfjfjdWPb+OZu3WZd3pWUcl8zE6r6o9s1my8/udFJ98WmqgvdrMFAGYbyRx7QZn4fNlQVCGcBc5UZVZuJA4CRcZzwmZJEL6ohlX1FkIXkdM+jmpgJ/tp9f4x5U/20Hhf2yu8kDHTPo5qFTB03+SFPrp6LDxmpZGR3pv8AGS2u4Op+K31Hym7E1m2FPXU2sbGiQx4Zs4sO+15hv149Ny47xtpzsyk+1YkpUDLBPA9gvAQtGsBWjERhADHCEAEYivHARkTJyJgRhFeOBALFaSkoFcJZCBWYsxlloWgV5jDOZZaK0LIBjHcyWWMrArLGIOZNhIFYQydhAe48ODu6s6f0zDfEUM9/T01FQU1YDtDfH8hLNnqfcFG2gNN0J1sMy2BPZNS99RlbNb4trk93Mdu7jun0X4mvDPG9WXHEcbdnZe057unC+gMh9HQ3U717CN47pfhwQLG510vvA5TB2ShWlTVt6qoNtQLDcOzlM8tPNZxWkvYo4oSFjjEUYgTE1O2f2imeAw5Hm6/hNsJpdtk+6KY/kbufpLMt/wDjrTV7xFXki8pWStOU9/C3PDPKxCDhcHEM0pjEscLi0WaVXgDCF2aGeUwAgX3kc0rvFeBZeErhAstC0ZiMAIhaAMDAAIQheAWhaF4XgOKF4XhZAiQY6EyxpVV3HuMRWtj0YQNgqAIBBpi4MvbZKXuMw1vb0WF/ESnomfgeH+jWbYzu4SdMcjLnqrWmnlNgfqEkBLK41lYmd8tIlCKEhJxiREmsCYmo2uff1+iT75txNLtVb4lTyoKN53lt9vAzLffhWmr2iAMkIlEllnKdAR2kQJK0sFaEeWAEBAQsI9Y4CtACMQhUisVpKECOWEd44EQ8eaU5xHmgWZo88oheBeGizSq8LwLs0RaVZow8LLLiO0gDeTEqEbSDqDpuvpeWtoLnQDUk6ATV4vaNgzU0DKiliWJXNbgNPrlpLUN30Ya2Dw/0azbdZNT0cX4Hhvo1me7TsYZWYxy8p3qNc3MgIE3kgI5IVo7SVo4SrkljIgsCazS7UPwm3HqUO7gGPHxE3SzmukGLZMUgVVYvSF819AG7Jju9K00z5xlJJXmHQ2iLgOuS+gN8y37TwmdOZZZ5dBG8UZjkBEwELR2lgQiCxgQCECIWMKiENY4ChHCBtzgU9URHZ1P1ZfmhmnT6Mfp4eq/bFOzE5GQOyU5mZuaGaR+vD6OvL7YB2QvMyJ2QODGbHNHmkXTh9J/Zl9tZ+p+Tw/U7etNqphVrKiNUdgiIpd3Y2VVAuSZH6cPpM25/bVjZD8xMXaWTDqGrVFTNoi6s7n+FRqe/cOM5ranTOvXYrhicPRBIDgA1ag5kkehw0Go5zTi+bO7NUdrAu7F3Pex1mGWGHiR6MOu+1b7E4/rNBcUxuU2Bbtb8JgbRxg6pxu9Bu7dKWqAaEzU7ZxBVHPMEb+ctMJJxG/iPTeixvgsIedBD/wCM2Lia3op+w4T6Cn9kTYtPXj4crLzUYncKpZiFVQWJJsFAFySeAjE1nSWgz4PFJTBLvRqBQN7HKfR8d3jLDnNodPsM9OslCs9KplypXei7JqRdlAub2vbMBrabTodt2hXp9VReu70EUO9dTne5+OWuRqb6Xv5Tw2enfom2guWvhrEVC/XhstwyWVCCeFjbf60iU4ekGAjMUkSWcT0wqZcZS1t7y1/6hO2Wef8AT18uMpH+UR9Ymez1aab84orYoAWbW4nT4VyadNjvNNCb8yonOdFNgPi36ypdcMhsW41WHyE7OZ8N+70B9kLwYieTPVllJw9uW7GXitMWhebM7H5OZjV9muuo9Idm+ZXTlP4rNuN/rGDRqZXmkwwmLVK8LwWGkBwvC0LQjg7wBiitLIO5hC0JUbyKBivOu553heRvCBKSEQk1ECSzgOnW3OsY4OifQRga7qdHcX967QDYntAHAzfdLNu9QnU0m+E1F0I/0UOmc/xcvPhrwuHwfYTxJNz4mYbc/wDWN9OH9qgDKl7HKNGPq9sk1UAXBBFpseqtcHUMLHkROb2nhXpktTN09Q65ezulcY3tWV8X585n9EdhPjqx63N7koWaqw0FRhqKIPM7zbcOVxM3ot0Gq4taWIruKOFqAtlUk13CsVsARZQbE5rnS2munRdNts0sFhlwGEVUZ1CMqf6NI7yT67czrqTymsnHes8tnPxxbPomfgGD/wC3pfYE2Rmu6NLbB4QcqFP7Amwaazw8d8kJKV3jBlhzOI6B4J6tSqyNeoSxph2WmrE3LALYi/K9uQmx6P8ARyhg1ZaAYlzdnchmYC9luANBc8Jt7wvIErxAyBMkskWLOJ6XYdKmMQVMzJTpoz00bIXDE2UvY5R6PAX7t47W88+6UVPhlQ33LSHgFv8AfMtt+LbRjLl3dds/pPRRUpvS9zooCIUIekijQA2AKjwM6Fj4/XPJhixaxnovR2sHweHIOa1PIT2qStvC0rhlfFab9eOPFjY5owZAxrLvO0O10y1PR+ULmYimZ23D74vdMJZzts4yr3a78YmDGWgIpk0MNHmiERF5YSzQvEFhAd4SNoSqrfRRXhedZzzjEiDJCBNRNZ0h2yuFpZtGq1LrSQ/Kbix/hFxfwHGZ2JxK06b1KhsiIzseNgL6czPK8Vj3xNZq1TjoibwlMHRB+PEkmU2ZdM7NNeHVf+LaKs7tUquWqVGzOzWJYn86Dume+IyD0UqG2/LTdvYJZgEFxbQ8wLzPdgAbsb8AMt/KeaPZY599oIdD6L8mBQ+RlmxNiNj65p5ilCmA1eou+xOiKfWax14AE8gc3E4VnVgQjX3ZwJg0nxyItGlWpYegNMuFVaTOd2Z2CBmYi1zfhNMbFMpfEdt0q6UUsFTGHw+Q1wgRKa2KYdALAsOwbl8545ia7vUNSozOztmZmN2JJ3kzc4nY7elc5m3ljqWPE353mgxKOjW3jtk3Lqqsw4j2zo/+yYX6Cn9kTNYzD2EPgmG+hp/YEyzPVPEeK+ahCEJIIXhCASYMhJLAsnl/TTE5MdVU8adFh/TY+wT1BZ5T+kxPhqFQSzUlBtroN3tmec7NNV4yaZsQx3f8z2fo3s9sPhKNN/j5c9TsdzmK+F7eE4f9HHR7rG91Vl97pNamh+XVGuYjkuh77cp6Y5lMZ/Wu3Pn4oGNZEmNTLsGk21/mD5swVmZtk++D5sxlnP2+1e7V6xMNGGiEkJm0ImImO0CIADFePLBlhUoQhA3cIQnUc8SayAk1kcjQ9PKhXAVbG12pKe0GotxPO8A1rX03Gei9O0vgKvY1I/8AtT8Z53g948LTHb5enR4dJgrncco7N8zQqjXf2nWYWABt+bzMbxmeMbWo1HJ3aDy+qUOuhlxvIvYS3CeWvdSb67py+16ZzajxnYumt+c57pHSsAwkVHL07Yo+C4b6Gn9gTJaY2yP2bD/Q0vsCZLT2Y+HPvlCEDCWQIQEIBGsUYgWrOB6Ulf1h6QvaivhqJ3yzzPpzWyY+/OioHnM8/VppvGUbvotismLRU0StmR1G4kKWU25gj6zO8aeKYDarJUp1AbZKiPfuYGe2VJTD6ab5OqWKjGsRjWXYtFtYXqnuExgOUyNqD3xu4Shbznbfavfr9YmIWjUERknlKLo3jWIN2SWaAZojAsIiYVF4QhA3N4XkQYTpPCmDJLKwZYsDRdOHIwVYb7mkPmjrE1+6ee4I6jWeg9NyBg6xP8oeBrJ94nnOGaZZ+W2rxXTYKruH5Mzmf88ppsC54zLuQb8OzhIkX5ZjEfdK379fZK1a+7cI2qAiWsTKkV07pp9u0r0Xv8kXE2anTT8iU7VTPRqDjkbdvGm+VqLXZ7H/AGbD/Q0/sCZJmF0exHWYTCuCWzUUuSbksFANzzuDM4ienHw8l8oGEdoWlkFaEdoWhBQEdoAQLFnlH6SmtjEP8u3snqwnl/T+vnxgTQhFItYaXC37931SmXhfX7OfwFBqr06aC71GWmg/iY2v3Df4T3tVsqre+VQL87C15wn6OtgBB7sdbEgrQBHA6NUHfqB48xO7YyuM/q+d57IGMSN5ISzNodo/5jeEpQSzHsetfvHslIE5ud+Ve/D1i4kwF5FdN8kGma4MlaQ1PZ42khfs81llUSYywjyHs81/GIr9UBWhI2EJUbYGSvIAx3nSeFMSxZUDLVMkc10+f4G38ToluZzhx9hvOcFgEzEC+p+LwDfwnk3Kdd0/e1FN5PXIQNdFKOb+YPlOVwlNai56ZXrB8Zfkv2Ec+2ZZ3u31+GwSpa4tqNCLW/JloxA35vumCHvo2ZXGmVzYjsDcfGSSgSbgMeYtrGNXbajXUjXyG+DdgPHnMSgbEDMF7zqJmF1G5r9tvvluUcKbkfndLHUsMu8vZfDiYlbmNOHGZlBQDmPDQDkeJlbU8MbZG1XwJalUpvUwjOWpsgzPQLaspXit9dN2s6JOlmCP/UoOxg6Ed4Imv6kFgTrYfWZVW2ejN6SKbj1R2ScdlnZW6ZW3/wAS4P8AeqXmfwj/AMSYT95pf1TmcRsGkSCEUWOthwMx6mwqY0Kix3Gw0l5tU/S67/EWE/eaP9YjHSHCfvVD+4onDYno6hHogd1ppX2SEcKw0b4p+6WmaLqeqjb+F/esP/dT8ZIbbw37zh/7qfjPLGwCcBJ4TYdbEVAtCmzAD0m+Kia/Kb7t8nqqt18PQdqdK8PTQ5HWq9vRVNVvzLbrd2s5bYHR2rjK7YrE3XDsc1z6LVdblU5Lf5Xbp2dJsXoXRpWesRXqDWxHvSn5vyvHynU34COLfKvMnhalgoVQFVQFVQLBQNAAJEmRWIyUJXkllYliwOdx2tR7c5VTW+8x4x/fKnzjII85eftXvwnxjItwi3SCueUatzlVlitw5+ElnPD2t+MpDywP4n2/n7pMRU83539v/PlKWfXj3dkkX+v8/nwldvOKgXhIwkDbAyYMITpPCkplga0IQPPP0hYwgqmubrr8xZaen/1H5E5rB16bkXzJU9andT48DCEpk2wdLhqFUrr1WJXlUUo4Hztb/VKalaihCuKuHY7gCtVfDfaOExjWrVxFO3o1nY8LoB4bpFs7H0Wv3gL7I4S8RWRSplR6RF+AA3XmZTw5BBLXtra2l4QkVpPDJQb+d/uEFfXWEJAbPK31BEIS0FQYadu+azaiKykctx5HnHCXVrC6M7MbFVurJyqAWqHS+UG2naT7Z6jhsOtNFSmoRFGij7+Z7YQmuPh5tgYyvNCEsyWq1xC8ISqQJYsIQOTxZ98f55kUEITm5e1dDD1i0E85K55xQlVizHsiFS2/2QhCA78ZE1BCECPWd8IQgf/Z", "Ipad");
        Category category2 = new Category(2, "", "Iphone");
        Category category3 = new Category(3, "", "MAC");
        Category category4 = new Category(4, "", "Watch");
        Category category5 = new Category (5, "", "Other");

        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
        categories.add(category4);
        categories.add(category5);
        CategoryAdapter categoryAdapter = new CategoryAdapter(getActivity(),categories);
        categoryRec.setAdapter(categoryAdapter);

//List product
        List<Product> productList = new ArrayList<>();
        Product product1 = new Product("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ3jwzqK0H_OwoQOTp6QyfwHkNWLOJ0Uh7xHrIfpnhf&s" ,"Ipad", 100, 1, 10,"Mô tả chi tiết");
        Product product2 = new Product("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ3jwzqK0H_OwoQOTp6QyfwHkNWLOJ0Uh7xHrIfpnhf&s", "Iphone 14", 25666000, 2, 5, "Mô tả chi tiết nè");
        Product product3 = new Product("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ3jwzqK0H_OwoQOTp6QyfwHkNWLOJ0Uh7xHrIfpnhf&s", "Macbook", 3200000, 3, 8, "Mô tả nữa nè");
        Product product4 = new Product("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ3jwzqK0H_OwoQOTp6QyfwHkNWLOJ0Uh7xHrIfpnhf&s", "Apple Watch", 1599000,4, 10, "Mô tả đây nha");
        Product product5 = new Product("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ3jwzqK0H_OwoQOTp6QyfwHkNWLOJ0Uh7xHrIfpnhf&s", "tai nghe", 1390000,5, 9 ," Mô tả nè ba");

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        ProductAdapter adapter = new ProductAdapter(getActivity(),productList);
        mRecyclerView.setAdapter(adapter);


//List Slide
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.bn1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.bnfstudio, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.bn2, ScaleTypes.FIT));
        imageSlider.startSliding(3000);
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
        return view;
    }
}
