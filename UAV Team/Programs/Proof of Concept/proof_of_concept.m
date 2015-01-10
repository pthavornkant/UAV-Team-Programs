function proof_of_concept

base_image = imread('heatmap.jpg');
%rename 'heatmap.jpg' to whatever filename of the photo you want to modify.
base_image = rgb2gray(base_image);
base_image_bin = binarify(base_image);

figure, imshow(base_image);
figure, imshow(base_image_bin);