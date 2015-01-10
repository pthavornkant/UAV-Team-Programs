function res = binarify( image )

[rows, columns] = size(image);

for i = 1:rows
        for j = 1:columns
            if (image(i, j) > 230) 
                %checks for values of "white shades." We want to make these
                %perfectly white to essentially remove them from the image.
                image(i, j) = 255;
            end
            if (image(i, j) > 20 && image(i, j) < 150)
                %check for "dark grayish" values from the original image.
                %These tend to fall in line with bad crops.
                image(i, j) = 20;
            end
        end
end

res = image;